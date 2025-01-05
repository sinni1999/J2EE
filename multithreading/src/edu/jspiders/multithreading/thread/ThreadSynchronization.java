package edu.jspiders.multithreading.thread;

// Synchronization is used to remove inconsistent output.

import edu.jspiders.multithreading.resource.Counter;

// By extending the Thread class, this class has the ability to run its own run() method in a separate thread.
public class ThreadSynchronization extends Thread{
	
	private Counter counter; // create instance variable of Counter type which is used to keep track of count.
	
	// no argument constructor
	// This constructor is the default one. It calls the superclass (Thread) constructor using super(). 
	//This doesn't initialize the counter variable.
	public ThreadSynchronization() {
		super();
	}

	// all argument constructor
	// This constructor allows you to initialize the counter variable by passing a Counter object as an argument. 
	//It sets the counter for the thread instance so that the thread can work with it in its run() method.
	public ThreadSynchronization(Counter counter) {
		super();
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for(int i =1;i<=100000;i++) {
			//  This suggests that Counter is a class that has an increment() method probably to increase a count.
			counter.increment();  
		}
	}
	
	
	

}
