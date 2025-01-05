package edu.jspiders.multithreading.main;

import edu.jspiders.multithreading.thread.ThreadProperties;

public class ThreadPropertiesMain {

	public static void main(String[] args) {

		ThreadProperties thread1 = new ThreadProperties();
		thread1.setName("thread 1"); // setName() - set the name of the thread.
		// using setPriority() we can set the priority of the thread highest priority thread executed first range(1-10).
		// low priority - 1  , highest priority - 10 , default priority - 5
		thread1.setPriority(5); 
		thread1.start();
		
		ThreadProperties thread2 = new ThreadProperties();
		thread2.setName("thread 2"); // we can set the name of thread as per our requirement.
		thread2.setPriority(10); // most of the time thread 2 executed first just because of highest priority 
		thread2.start();

	}

}

// Note:-We can set Name and Priority of the thread but we cannot set the Thread Id because its system generated it is handled by JVM.
