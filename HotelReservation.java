package com.Capg.HotelReservation;

import java.util.*;

public class HotelReservation {
	private List<Hotels> hotelList = new ArrayList<>();
	
	public List<Hotels> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotels> hotelList) {
		this.hotelList = hotelList;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation Program");
		HotelReservation hotelMainObj = new HotelReservation();
		hotelMainObj.addHotels();
	}
	
	public void addHotels()
	{
		Scanner sc = new Scanner(System.in);
		char ch;
		String hName;
		int rate;
		do
		{
			System.out.println("Enter the name of hotel:" );
			hName =sc.nextLine();
			System.out.println("Enter the rate for regular customer:" );
			rate = Integer.parseInt(sc.nextLine());
			Hotels hotelObj = new Hotels(hName, rate);
			hotelList.add(hotelObj);
			setHotelList(hotelList);
			System.out.println("Do you want to add more hotels (y/Y-n/N): ");
			ch = sc.next().charAt(0);
			sc.nextLine();
		} while(ch=='y' || ch=='Y');
		System.out.println("List of Hotels and rate of regular customer:");
		hotelList.stream().forEach((obj) -> System.out.println(obj));
	}
}
