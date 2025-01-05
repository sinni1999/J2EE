package edu.jspiders.multithreading.main;

import edu.jspiders.multithreading.thread.MyThread1;

public class MainThread1 {

	public static void main(String[] args){
		
		long start = System.currentTimeMillis(); // currentTimeMillis() present inside System ,it gives current system time.
	
		MyThread1 thread1 = new MyThread1(); // Object creation of MyThread1
		thread1.start(); // start()-non-static method present inside thread class. used to start the execution of current thread.
		
		MyThread1 thread2  = new MyThread1();
		thread2.start();
		
		long end = System.currentTimeMillis(); // give current system time.
		
		System.out.println(end-start + " ms takes to execute this thread using thread class"); // it gives start to end thread execution time

	}

}

// note- we don't need to create the object of Thread class because this class extends Thread class.