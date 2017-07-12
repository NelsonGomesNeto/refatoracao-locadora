package com.locadora;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private String name;
	
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		String result = "Rental Record for " + getName() + "\n";
		
		for (Rental each : rentals) {
			double thisAmount = each.getCharge();
			frequentRenterPoints += each.getFrequentRenterPoints();
			
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		
		return result;
	}

	public String getName() {
		return name;
	}
	
}