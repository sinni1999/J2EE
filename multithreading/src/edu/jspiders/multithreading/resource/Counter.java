package edu.jspiders.multithreading.resource;

public class Counter {
	
	private int count; // create private variable count 

	// no argument constructor
	public Counter() {
		super();
	}

	// all argument constructor
	// This constructor allows for initializing the count with a specific value when a Counter object is created.
	public Counter(int count) {
		super();
		this.count = count;
	}

	// The increment() method increases the value of count by 1.
	// The increment() method is synchronized to ensure that only one thread can modify the count at a time. 
	//This prevents issues like race conditions when multiple threads are trying to update the count concurrently.
	synchronized public void increment() {
		this.count++;
		
	}
	// The getCount() method simply returns the current value of the count variable.
	public int getCount() {
		return this.count;
	}

}
