package edu.jspiders.multithreading.resource;

public class Product {
	
	private int quantity; // quantity is used to check quantity of the product how much product is available.

	public Product(int quantity) {
		super();
		this.quantity = quantity;
	}
	// consume() - used to consume the product if product is greater than 0.
	synchronized public void consume() {
		// check if product is greater than 0 or not if >0 then consumer consume that product means product is decreases.
		if(quantity>0) {
			this.quantity--;
		}else {
			// if product is not available means 0 then consumer has to be wait until product is not produced.
			System.out.println("Consumer is waiting");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumer consumed a product");
	}
	
	// produce()- used to produce the product if product is < 0 means not available.
	synchronized public void produce() {
		this.quantity++;
		System.out.println("Producer produced a product");
		if(quantity==1) // it means once product is produced then notify the consumer.
			notify();
		
	}
	

}
