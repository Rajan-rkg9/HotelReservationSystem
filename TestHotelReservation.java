package com.Capg.HotelReservation;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

class TestHotelReservation {
	static HotelReservation hotelReservation = null;
	@BeforeClass
	 public  static void setUp() {
		 hotelReservation = new HotelReservation();
	 }

	@Test
	public void shouldSayYes() {
		assertTrue(true);
	}

}
