package com.Capg.HotelReservation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class HotelReservation {
	private List<Hotels> hotelList = new ArrayList<>();
	private final List<String> WEEKENDS = Arrays.asList(new String[] { "(sat)", "(sun)" });
	private static final Pattern DAY_PATTERN = Pattern.compile("\\([a-z]{3,4}\\)");

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
		hotelMainObj.findCheapestBestRatedHotelForRegularCustomer();
		hotelMainObj.findBestRatedHotel();
		hotelMainObj.findCheapestBestRatedHotelForRewardsCustomer();
	}
	
	/**
	 *UC1
	 */
	public void addHotels()
	{
		char ch;
		String hName;
		int regularWDRate ,regularWERate ,rating ,rewardsWDRate ,rewardsWERate ;
		do
		{
			System.out.println("Enter the name of hotel:" );
			hName =sc.nextLine();
			System.out.println("Enter Rating of Hotel:");
			rating = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the Weekday rate for regular customer:" );
			regularWDRate = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the Weekend rate for regular customer:" );
			regularWERate = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the Weekday rate for rewards customer:" );
			rewardsWDRate = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the Weekend rate for rewards customer:" );
			rewardsWERate = Integer.parseInt(sc.nextLine());
			Hotels hotelObj = new Hotels(hName, regularWDRate ,regularWERate , rewardsWDRate ,rewardsWERate, rating);
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
	 *UC12 USING JAVA STREAMS
	 */
	public void findCheapestBestRatedHotelForRegularCustomer()
	{
		System.out.println("Enter the date range as <date1>, <date2>, <date3> Eg.: 11Sep2020(sun), 11Sep2020(mon)");
		String dateRange = sc.nextLine();
		//String range[] = dateRange.split(",");
		Matcher dayMatcher = DAY_PATTERN.matcher(dateRange);
		List<String> daysList = new ArrayList<String>();
		while (dayMatcher.find()) {
			daysList.add(dayMatcher.group());
		}
		int noOfWeekend =(int)  daysList.stream().filter(day -> WEEKENDS.contains(day)).count();
		int noOfWeekDay = daysList.size() - noOfWeekend;
		Map<Hotels , Integer> hotelRateMap=hotelList.stream().collect(Collectors.toMap(k->k ,v-> v.getRegularWeekDayRate()* noOfWeekDay + v.getRegularWeekEndRate()*noOfWeekend));
		Hotels cheapestRate=hotelRateMap.keySet().stream().min((d1,d2) -> {
			int minRate = hotelRateMap.get(d1) - hotelRateMap.get(d2);
			int minRating = d1.getRating() - d2.getRating();
			return minRate == 0 ? -(minRating) : minRate;
		}).orElse(null);
		System.out.println(cheapestRate.getNameOfHotel() + ", Rating : "+ cheapestRate.getRating() +" and Total Rates: $" + hotelRateMap.get(cheapestRate));
	}
	
	public void findBestRatedHotel()
	{
		System.out.println("Enter the date range as <date1>, <date2>, <date3> Eg.: 11Sep2020(sun), 11Sep2020(mon)");
		String dateRange = sc.nextLine();
		//String range[] = dateRange.split(",");
		Matcher dayMatcher = DAY_PATTERN.matcher(dateRange);
		List<String> daysList = new ArrayList<String>();
		while (dayMatcher.find()) {
			daysList.add(dayMatcher.group());
		}
		int noOfWeekend =(int)  daysList.stream().filter(day -> WEEKENDS.contains(day)).count();
		int noOfWeekDay = daysList.size() - noOfWeekend;
		Hotels bestRate = hotelList.stream().max((hotel1, hotel2) -> hotel1.getRating() - hotel2.getRating()).orElse(null);
		int totalRate = bestRate.getRegularWeekDayRate() * noOfWeekDay
				+ bestRate.getRegularWeekEndRate() * noOfWeekend;
		System.out.println(bestRate.getNameOfHotel() + " & Total Rates $" + totalRate);
	}
	
	/**
	 * UC12  USING JAVA STREAMS
	 */
	public void findCheapestBestRatedHotelForRewardsCustomer() 
	{
		System.out.println("Enter the date range as <date1>, <date2>, <date3> Eg.: 11Sep2020(sun), 11Sep2020(mon)");
		String dateRange = sc.nextLine();
		//String range[] = dateRange.split(",");
		Matcher dayMatcher = DAY_PATTERN.matcher(dateRange);
		List<String> daysList = new ArrayList<String>();
		while (dayMatcher.find()) {
			daysList.add(dayMatcher.group());
		}
		int noOfWeekend =(int)  daysList.stream().filter(day -> WEEKENDS.contains(day)).count();
		int noOfWeekDay = daysList.size() - noOfWeekend;
		Map<Hotels , Integer> hotelRateMap=hotelList.stream().collect(Collectors.toMap(k->k ,v-> 
											v.getRewardsWeekDayRate()* noOfWeekDay + v.getRewardsWeekEndRate()*noOfWeekend));
		Hotels cheapestRate=hotelRateMap.keySet().stream().min((d1,d2) -> {
			int minRate = hotelRateMap.get(d1) - hotelRateMap.get(d2);
			int minRating = d1.getRating() - d2.getRating();
			return minRate == 0 ? -(minRating) : minRate;
		}).orElse(null);
		System.out.println(cheapestRate.getNameOfHotel() + ", Rating : "+ cheapestRate.getRating() +" and Total Rates: $" + hotelRateMap.get(cheapestRate));
	}
}
