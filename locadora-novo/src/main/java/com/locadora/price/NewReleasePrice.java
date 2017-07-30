package com.locadora.price;

import com.locadora.Movie;

public class NewReleasePrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	
	public double getCharge(int daysRented) {
		return daysRented * 3;
	}
	
	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return daysRented > 1 ? 2 : 1;
	}

}