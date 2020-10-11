package com.Capg.HotelReservation;

public class Hotels {
	private String nameOfHotel;
	private int regularRate;
	public Hotels(String nameOfHotel, int regularRate) {
		super();
		this.nameOfHotel = nameOfHotel;
		this.regularRate = regularRate;
	}
	public String getNameOfHotel() {
		return nameOfHotel;
	}
	
	public void setNameOfHotel(String nameOfHotel) {
		this.nameOfHotel = nameOfHotel;
	}
	public int getRegularRate() {
		return regularRate;
	}
	public void setRegularRate(int regularRate) {
		this.regularRate = regularRate;
	}
	@Override
	public String toString() {
		return "Hotel Name: " + nameOfHotel + ", Regular Rate: $" + regularRate;
	}
}
