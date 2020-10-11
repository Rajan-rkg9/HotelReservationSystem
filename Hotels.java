package com.Capg.HotelReservation;

public class Hotels {
	private String nameOfHotel;
	private int regularWeekDayRate;
	private int regularWeekEndRate;
	public Hotels(String nameOfHotel, int regularWeekDayRate , int regularWeeekEndRate) {
		super();
		this.nameOfHotel = nameOfHotel;
		this.regularWeekDayRate = regularWeekDayRate;
		this.regularWeekEndRate = regularWeekEndRate;
	}
	public String getNameOfHotel() {
		return nameOfHotel;
	}
	
	public void setNameOfHotel(String nameOfHotel) {
		this.nameOfHotel = nameOfHotel;
	}
	public int getRegularWeekDayRate() {
		return regularWeekDayRate;
	}
	public void setRegularWeekDayRate(int regularWeekDayRate) {
		this.regularWeekDayRate = regularWeekDayRate;
	}
	public int getRegularWeekEndRate() {
		return regularWeekEndRate;
	}
	public void setRegularWeekEndRate(int regularWeekEndRate) {
		this.regularWeekEndRate = regularWeekEndRate;
	}
	@Override
	public String toString() {
		return "Hotel Name: " + nameOfHotel + ", Regular WeekDayRate: $" + regularWeekDayRate + ", Regular WeekEndRate: $" + regularWeekEndRate;
	}
}
