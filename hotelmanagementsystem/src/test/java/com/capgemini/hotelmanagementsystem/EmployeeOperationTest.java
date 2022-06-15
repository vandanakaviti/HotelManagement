package com.capgemini.hotelmanagementsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.revature.hotelmanagementsystem.dao.BookingOperationDAO;
import com.revature.hotelmanagementsystem.dao.HotelOperationDAO;
import com.revature.hotelmanagementsystem.dao.RoomOperationDAO;
import com.revature.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.revature.hotelmanagementsystem.validation.HotelValidationImpl;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeOperationTest {
	
	@Autowired
	private BookingOperationDAO bookingOperationDao;
	@Autowired
	private RoomOperationDAO roomOperationDao;
	
	@Autowired
	private HotelOperationDAO hotelOperationDao;
	
	@Autowired
	private HotelValidationImpl hotelValidation;

	
	// Passed Case with valid Information
	@Test
	public void testGetHotelInformation() {
		AdminEmployeeUserBean employeeBean = new AdminEmployeeUserBean();
		employeeBean.setEmail("mayuri@taj.com");
		TestCase.assertNotNull(bookingOperationDao.getBookingHistory(employeeBean.getEmail()));

	}// End of testGetHotelInformation()

	// Invalid Test Case with invalid Information
	@Test
	public void testInvalidGetHotelInformation() {
		AdminEmployeeUserBean employeeBean = new AdminEmployeeUserBean();
		employeeBean.setEmail("emplo@qwerty.com");
		TestCase.assertNull(bookingOperationDao.getBookingHistory(employeeBean.getEmail()));

	}// End of testGetHotelInformation()

	
}// End of EmployeeOperationTest()
