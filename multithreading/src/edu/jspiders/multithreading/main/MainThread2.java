package edu.jspiders.multithreading.main;

import edu.jspiders.multithreading.thread.MyThread2;

public class MainThread2 {

	public static void main(String[] args) throws InterruptedException {
		
		long start = System.currentTimeMillis();
		
		MyThread2 thread1 = new MyThread2(); // creating the object of MyThread2
		Thread t1 = new Thread(thread1); // We have to create object of Thread class because start() is present inside Thread class.
		t1.start(); // start() is used to start the current the thread.
		
		// new Thread(new MyThread2()).start();  we can also created like this
		Thread.sleep(2000);
		
		MyThread2 thread2 = new MyThread2(); // creating the obj of MyThread2
		Thread t2 = new Thread(thread2); // We have to create object of Thread class because start() is present inside Thread class.
		t2.start();
		
		long end = System.currentTimeMillis();
		System.out.println(end-start-2000 + " ms to execute the thread include sleep time ");

	}

}
