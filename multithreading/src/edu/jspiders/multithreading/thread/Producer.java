package edu.jspiders.multithreading.thread;

import edu.jspiders.multithreading.resource.Product;

public class Producer extends Thread{
	
	private Product product;

	public Producer(Product product) {
		super();
		this.product = product;
	}
	
	public void run() {
		product.produce(); // product is produced using produce().
	}

}
