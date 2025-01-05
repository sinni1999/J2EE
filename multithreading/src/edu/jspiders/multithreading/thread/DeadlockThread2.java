package edu.jspiders.multithreading.thread;

import edu.jspiders.multithreading.resource.Resource;

public class DeadlockThread2 extends Thread{
	
	private Resource resource;

	public DeadlockThread2(Resource resource) {
		super();
		this.resource = resource;
	}
	
	public void run() {
		// synchronized block locks object1 from the resource object.
		synchronized (resource.object1) {
			try {
				System.out.println("Thread 2 applied lock on resource 2");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		// // synchronized block locks object1 from the resource object.
		synchronized (resource.object2) {
			try {
				System.out.println("Thread 2 applied lock on resource 1");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

}
