package edu.jspiders.multithreading.main;

import edu.jspiders.multithreading.resource.Resource;
import edu.jspiders.multithreading.thread.DeadlockThread1;
import edu.jspiders.multithreading.thread.DeadlockThread2;

public class DeadlockMain {

	public static void main(String[] args) {
		
		Resource resource = new Resource();
		
		DeadlockThread1 dt1 = new DeadlockThread1(resource);
		DeadlockThread2 dt2 = new DeadlockThread2(resource);
		
		dt1.start();
		dt2.start();
	}

}

// When deadlock occurs?
// forcefully we are generating deadlock to understand the deadlock concept.
/*
 The DeadlockThread2 class demonstrates a deadlock scenario because of the way the locks are being acquired:

Thread 2 first acquires a lock on object1 (part of resource), and then it tries to acquire a lock on object2.
However, at the same time, Thread 1 might be running, and it could have already locked object2 and is now trying to acquire a lock on object1.
In this case:

Thread 1 holds a lock on object2 and tries to acquire a lock on object1.
Thread 2 holds a lock on object1 and tries to acquire a lock on object2.
This results in a situation where:

Thread 1 is waiting for Thread 2 to release object1.
Thread 2 is waiting for Thread 1 to release object2.
This creates a deadlock, where neither thread can proceed because each is waiting on the other to release a lock.
*/