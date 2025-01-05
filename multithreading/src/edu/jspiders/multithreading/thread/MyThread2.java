package edu.jspiders.multithreading.thread;

public class MyThread2 implements Runnable{

	@Override
	public void run() {
		
		for(int i = 1 ; i<=100000 ; i++){
			System.out.println(i);
		}
		
	}

}
