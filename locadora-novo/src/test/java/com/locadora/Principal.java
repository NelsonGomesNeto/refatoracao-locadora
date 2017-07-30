package com.locadora;

public class Principal {

	public static void main(String[] args) {
		
		Customer c = new Customer("Rafael Monteiro");
		c.addRental(new Rental(new Movie("Homem Aranha", 1), 2));
		c.addRental(new Rental(new Movie("Mulher Maravilha", 0), 1));
		
		System.out.println(c.statement());
		
	}
	
}
