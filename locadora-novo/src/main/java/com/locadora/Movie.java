package com.locadora;

import com.locadora.price.ChildrensPrice;
import com.locadora.price.NewReleasePrice;
import com.locadora.price.Price;
import com.locadora.price.RegularPrice;

public class Movie {
	
	public static final int CHILDRENS = 2;

	public static final int REGULAR = 0;

	public static final int NEW_RELEASE = 1;

	private String title;

	private Price price;

	
	public Movie(String title, int priceCode) {
		this.title = title;
		this.setPriceCode(priceCode);
	}
	
	public double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}
	
	public void setPriceCode(int priceCode) {
		switch (priceCode) {
			case Movie.REGULAR :
				price = new RegularPrice();
				break;
			case Movie.NEW_RELEASE :
				price = new NewReleasePrice();
				break;
			case Movie.CHILDRENS :
				price = new ChildrensPrice();
				break;
			default :
				throw new IllegalArgumentException("Incorrect Price Code.");
		}
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}

	public int getPriceCode() {
		return price.getPriceCode();
	}

	public String getTitle() {
		return title;
	}
	
}