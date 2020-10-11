package com.Capg.HotelReservation;

import java.util.*;
import java.util.stream.Collectors;

public class HotelReservation {
	private List<Hotels> hotelList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
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
		hotelMainObj.findCheapestHotel();
	}
	
	/**
	 *UC1
	 */
	public void addHotels()
	{
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
	
	/**
	 *UC2
	 */
	public void findCheapestHotel()
	{
		System.out.println("Enter the date range as <date1>, <date2>, <date3> Eg.: 11Sep2020, 11Sep2020");
		String dateRange = sc.nextLine();
		String range[] = dateRange.split(",");
		Map<Hotels , Integer> hotelRateMap=hotelList.stream().collect(Collectors.toMap(k->k ,v->v.getRegularRate()*range.length));
		Hotels cheapestRate=hotelRateMap.keySet().stream().min((d1,d2)->hotelRateMap.get(d1) - hotelRateMap.get(d2)).orElse(null);
		System.out.println(cheapestRate.getNameOfHotel() + ", Total Rates: $" + hotelRateMap.get(cheapestRate));
	}
}
