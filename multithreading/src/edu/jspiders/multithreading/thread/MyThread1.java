package edu.jspiders.multithreading.thread;

public class MyThread1 extends Thread{
	
	@Override
	// run() - non-static method present inside runnable interface
	public void run() {
		for(int i = 1;i<=100000;i++) {
			System.out.println(i);
		}
	}

}
