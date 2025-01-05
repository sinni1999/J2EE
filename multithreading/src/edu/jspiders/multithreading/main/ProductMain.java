package edu.jspiders.multithreading.main;

import edu.jspiders.multithreading.resource.Product;
import edu.jspiders.multithreading.thread.Consumer;
import edu.jspiders.multithreading.thread.Producer;

public class ProductMain {

	public static void main(String[] args) {
		
		Product product = new Product(2);
		
		Consumer consumer = new Consumer(product);
		consumer.start();
		Producer producer = new Producer(product);
		producer.start();
		
		
		

	}

}

/*
 output:-
 case 1: product = 0.
 if Product product = new Product(0).
 Consumer is waiting
 Producer produced a product.
 Consumer consumed a product.
 
 case 2: product > 0.
Consumer consumed a product
Producer produced a product
 */
  
