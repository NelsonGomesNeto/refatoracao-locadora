package com.locadora;

public class Rental {
	
	private Movie movie;

	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	public double getCharge() {
		double result = 0.0;
		
		switch (movie.getPriceCode()) {
			case Movie.REGULAR :
				result += 2;
				if (daysRented > 2)
					result += (daysRented - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE :
				result += daysRented * 3;
				break;
			case Movie.CHILDRENS :
				result += 1.5;
				if (daysRented > 3)
					result += (daysRented - 3) * 1.5;
				break;
		}
		
		return result;
	}
	
	public int getFrequentRenterPoints() {
		if (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
			return 2;

		return 1;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}
	
}