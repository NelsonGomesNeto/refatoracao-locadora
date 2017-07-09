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
			double thisAmount = amountFor(each);
			
			//add frequent renter points
			frequentRenterPoints++;
			//add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;
			
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		
		return result;
	}

	private double amountFor(Rental rental) {
		double result = 0.0;
		
		switch (rental.getMovie().getPriceCode()) {
			case Movie.REGULAR :
				result += 2;
				if (rental.getDaysRented() > 2)
					result += (rental.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE :
				result += rental.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS :
				result += 1.5;
				if (rental.getDaysRented() > 3)
					result += (rental.getDaysRented() - 3) * 1.5;
				break;
		}
		
		return result;
	}
	
	public String getName() {
		return name;
	}
	
}