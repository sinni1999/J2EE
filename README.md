# J2EE/MultiThreading

Basic Commands in MYSQL :-
	1. Show databases;
	2. Create datbase datbase_name;
	3. Use database_name;
	4. Show tables;
	5. Create table user(id int primary key, name varchar(20) not null, email varchar(20) not null unique);
	6. Select * from table_name;
	7. Insert into user values(1,'ram','ram@gmail.com');
	8. Drop table table_name;
	9. System cls;  clear the screen.
	
	
Workspace :-
It is  the place where our work will be saved. It is a folder or directory.
It is a directory where all the project created by the programmer will be saved.


Launching Workspace in Eclipse :-
Whenever we open eclipse IDE one popup appears asking for the workspace to be launched.
By Default one workspace would be selected, we can change it using browse option and then click on launch button.

Switching workspace in eclipse :-
In the eclipse , go to the file section at the bottom we have an option as switch workspace from there we can select the workspace which we want to switch.


Steps to create java project in eclipse :-
	1. Press ctrl+N and search for java project select it and click enter.
	2. Provide name for the project for following convention(project name in lowercase alphabet).
	3.  select the appropriate java runtime environment(keeping default is recommended). Uncheck the checkbox has "create-module-information.java file" click on finish.


Structure of Java Project:-
Demoapp(name of the project)
	Þ JRE System Library(JavaSE - 21)
	Þ Src

The programmer will create java source file under src folder inside the package.

Standard Format of providing names to the packages : -  domain.host.package_name.


Shortcut in Eclipse :-

	1. Ctrl + N :-  To create any new component in eclipse IDE we can making this shortcut.
	2. Ctrl + space :- This shortcut can be used to get the suggetion from the eclipse IDE.
	3. Alt + shift + S :- This can be used to generate getters, setters , toString() , hashCode(),equals() and constructors(parameterized or non-parameterized).
	4. Ctrl + shift + T : This shortcut can be used to search classes, interfaces , enums present inside the library.
	5. Ctrl + shift + 0 : To remove the unwanted import statement.
Ctrl + 1 : This shortcut is used to assign a value to a local variable.


Multitasking :-
Task is nothing but the application running on the system.
Using or executing multiple application simultaneously on the system is called as multitasking.

Multiprocessing :- 
Process is a subtask  , so running multiple process simultaneously on the system is called as multiprocessing.
It is heavyweight .
Each process has its own memory space , no sharing.
Communicate through - Inter process communication(IPC).
Switching is done by OS.

Note :- Processor(CPU) is responsible for executing java programs.


Multithreading :-
Thread is the smallest unit of a task which can be referred as a program. (Thread is just a lightweight process or subprocess). -> common memory sharing -> Context switching -light.
Executing multiple programs(threads) simultaneously is called as  multithreading.
Through multithreading we can utilize CPU time efficiently.
By default every program is single threaded(main thread is created by JVM). Main() also called as main thread.


Creating Thread in Java:-
	1. Using Runnable Interface. - It has only one abstract method i.e run() so it called as functional interface after java 8. support multiple inheritance.
	2. Using Thread class. - We have to define run() here. It implements runnable interface so run() is not by default present here .we gave to define . 
	3. If one class extends Thread class then it cannot extends another class because it does not support multiple inheritance hence we can use runnable interface.


First way of creating thread in java. (Using Runnable Interface):-

Thread1.java :
package com.jspiders.multithreadingnew.thread;

public class Thread1 implements Runnable{
	
	@Override
	public void run() { // run() is an abstract method present inside a runnable interface.
		System.out.println("Thread1 is creating using runnable interafce ");
		for(int i = 1;i<=10;i++) {
			System.out.println(3*i);	
		}
	}	
}

ThreadMain1.java :
package com.jspiders.multithreadingnew.main;

import com.jspiders.multithreadingnew.thread.Thread1;

public class ThreadMain1 {

	public static void main(String[] args) {
		
		Thread1 thread1 = new Thread1();
		Thread t1 = new Thread(thread1);
		t1.start(); // start() is a non-static method present in Thread class		
	}
}

Second way of creating thread in java. (Using Thread class):-
Thread2.java :
package com.jspiders.multithreadingnew.thread;

public class Thread2 implements Runnable{
	
	@Override
	public void run() {
		System.out.println("Thread2 is creating using thread class ");
		for(int i = 1;i<=10;i++) {
			System.out.println(3*i);	
		}
	}	
}

ThreadMain2.java :
package com.jspiders.multithreadingnew.main;

import com.jspiders.multithreadingnew.thread.Thread2;

public class ThreadMain2 {

	public static void main(String[] args) {
		
		Thread2 thread2 = new Thread2();
		t1.start();		
	}
}

Thread lifecycle has 4 phases and 6 transitions.

Thread Scheduler :-
It is a component of JVM which controls thread life cycle.

1. start -----------------> 2. running ----------------------------> 5. stop
3. start------------------> 4. waiting ----------------------------> 6. stop.


Note:-
A programmer cannot control the a thread lifecycle, it completely depends on the thread scheduler.
Thread Scheduler manage the thread state but internally OS execute that thread

Following are the factors which will be taken into consideration by the thread scheduler to manage the thread lifecycle.:-

	1. Sometime thread scheduler follows FCFS(First Come First Serve) principle.
	2. The priority of each and every thread (Higher priority thread has executed  maximum first).
	3. System configuration(depends upon the OS, Processor).

NOTE:- Thread Scheduler will allocate CPU to a thread for its execution for specific interval of time (not always).



Transition of thread lifecycle:-
	1. Start Phase :
	When the execution of thread is about to start after calling start method then the thread will be in start phase.
	
  2.     start to running phase:
	A thread moves from start to running phase once after the thread scheduler allocates CPU to the threads.
	
	3. Running to waiting phase :-
	If the thread scheduler revokes the allocated CPU to the thread then the thread moves from running to waiting phase.
	
	4. Waiting to running phase :
	If the thread schedular allocates the CPU to a thread to resume its execution then the thread moves from waiting to running phase.
	
	5. Running to stop phase :
	If the thread completes its execution then the thread moves from running to stop phase.
	
	6. Waiting to stop phase :
	 if the thread is waiting for CPU allocation for too long time then it automatically moves from waiting to stop phase.
	
	
	
	Executing multiple threads :-
	
	Thread3.java:
	package com.jspiders.multithreadingnew.thread;
	
	public class Thread3 implements Runnable{
		
		@Override
		public void run() {
			for(int i = 1;i<=10;i++) {
				System.out.println(i);	
			}
		}	
	}
	ThreadMain3.java
	
	
	package com.jspiders.multithreadingnew.main;
	
	import com.jspiders.multithreadingnew.thread.Thread3;
	
	public class ThreadMain1 {
	
		public static void main(String[] args) {
			
			Thread3 thread3 = new Thread3();
			new Thread(new thread3()).start();
			   new Thread(new thread3()).start();
		}
	}
	
	
	Note:-
	The runnable interface and the thread class both are present in java.lang package.
	
	Join():-
	It will pause the current thread until other threads finishes their execution.(To collect data from the database till main() has to be paused that’s why join is used.)
	
	Run():-
	It is an abstract method present inside runnable interface.
	
	Start():-
	It is a non-static method present inside the thread class.
	
	Note*** :- 
	Each and every thread will have a dedicated stack memory where each and every thread will be executed independently.
	
	
	Properties of a Thread :-
	1. Id :- 
	It is given by a JVM itself.
	We can fetch this property using a method called as getId() which is a non-static method present inside thread class.
	
	2. Name :-
	It is modifiable i.e we can change the name of the thread by using setName(String name).
	We can fetch the name of the thread by using getName().
	
	3. Priority:- range(1-10)
	A newly created thread will have the priority as 5(default),the minimum priority can be 1 and maximum priority can be 10.
	We can set the priority value using setPriority(int priority)
	We can fetch the priority value using getPriority().
	Thread scheduler generally picks the high priority thread first.
	High priority -> more CPU cycle.
	
NOTE :-
From java(19) the getId is depricated(outdated). So in order to fetch the id of the thread we can make use of threadId().


