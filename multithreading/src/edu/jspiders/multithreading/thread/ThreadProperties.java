package edu.jspiders.multithreading.thread;

// Thread properties name and id and priorities
public class ThreadProperties extends Thread{

	@Override
	public void run() {

		for(int i = 1;i<=10;i++) {
			// we can set the name but we cannot set the id it is generated by system itself.
			System.out.println(this.getName() + " is running with the " + this.threadId());
		}
		
	}

}
