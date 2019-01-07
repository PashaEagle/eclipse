package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.booking.dao.BookingDao;
import com.app.model.Booking;
import com.app.model.UserDetails;
import com.app.user.dao.UserDao;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookingDao bookingDao;

	public List<Booking> findUserBookings(String emailId) {
		UserDetails userdetails = userDao.findByEmail(emailId);
		List<Booking> bookings = bookingDao.findByCreatedBy(userdetails.getId());
		return bookings;
	}
}