package com.capgemini.hotelmanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.hotelmanagementsystem.bean.BookingInformationBean;
import com.revature.hotelmanagementsystem.bean.HotelInformationBean;
import com.revature.hotelmanagementsystem.bean.RoomInformationBean;
import com.revature.hotelmanagementsystem.dao.BookingOperationDAO;
import com.revature.hotelmanagementsystem.dao.RoomOperationDAO;
import com.revature.hotelmanagementsystem.validation.HotelValidationImpl;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserOperationTest {
	
	@Autowired
	private BookingOperationDAO bookingOperationDao;
	@Autowired
	private RoomOperationDAO roomOperationDao;
	@Autowired
	private HotelValidationImpl hotelValidation;
	
	
	@Test
	// valid roomList()
	public void testRoomList() {
		//HotelInformationBean hotelInformation = new HotelInformationBean();
		//hotelInformation.setLicenceNumber("H10101010");
		TestCase.assertNotNull(roomOperationDao.roomList("H10101010"));
	}

	@Test
	// Invalid test roomList()
	public void testInvalidRoomList() {
		HotelInformationBean hotelInformation = new HotelInformationBean();
		hotelInformation.setLicenceNumber("H00");
		List<RoomInformationBean> roomList = roomOperationDao.roomList(hotelInformation.getLicenceNumber());
		assertEquals(true, roomList.isEmpty());
	}

	@Test
	// Valid test getBookingHistroy()
	public void testGetBookingHistory() {
		List<BookingInformationBean> bookingHistroy = bookingOperationDao.getBookingHistory("user@gmail.com");
		assertEquals(true, bookingHistroy.isEmpty());
	}

	@Test
	// invalid test getBookingHistroy()
	public void testInvalidGetBookingHistory() {
		List<BookingInformationBean> bookingHistroy = bookingOperationDao.getBookingHistory("user12@gmail.com");
		assertEquals(true, bookingHistroy.isEmpty());
	}

}
