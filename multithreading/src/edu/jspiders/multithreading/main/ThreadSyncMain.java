package edu.jspiders.multithreading.main;

import edu.jspiders.multithreading.resource.Counter;
import edu.jspiders.multithreading.thread.ThreadSynchronization;

public class ThreadSyncMain {

	public static void main(String[] args) throws InterruptedException {
		
		Counter counter  = new Counter(0);
		
		ThreadSynchronization thread1 = new ThreadSynchronization(counter);
		
		ThreadSynchronization thread2 = new ThreadSynchronization(counter);
		
		thread1.start();
		thread2.start();
		
		Thread.sleep(500);
		
		System.out.println(counter.getCount());
		
	}

}

// just because of synchronized increment() we will get the consistent output - 200000.
