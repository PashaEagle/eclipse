package com.app.service;

import java.util.List;

import com.app.model.Booking;

public interface BookingService {
	public List<Booking> findUserBookings(String emailId);
}
