package com.capgemini.hotelmanagementsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.revature.hotelmanagementsystem.dao.AdminEmployeeUserDao;
import com.revature.hotelmanagementsystem.dao.BookingOperationDAO;
import com.revature.hotelmanagementsystem.dao.RoomOperationDAO;
import com.revature.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.revature.hotelmanagementsystem.validation.HotelValidationImpl;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminEmployeeUserTest {
	
	@Autowired
	private BookingOperationDAO bookingOperationDao;
	@Autowired
	private RoomOperationDAO roomOperationDao;
	@Autowired
	private HotelValidationImpl hotelValidation;

	@Autowired
	private AdminEmployeeUserDao adminEmployeeUserDaoImpl; // autowired
	// Passed

	@Test
	public void testGetLogin() {
		TestCase.assertNotNull(adminEmployeeUserDaoImpl.adminEmployeeUserLogin("admin@gmail.com"));

	}// End of testGetLogin()

	@Test
	// Invalid test getLogin
	public void testInvalidGetLogin() {
		TestCase.assertNull(adminEmployeeUserDaoImpl.adminEmployeeUserLogin("anji@gmail.com"));
	}
	
	@Test
	// Invalid test userRegister
	public void testInvalidUserRegister() {
		AdminEmployeeUserBean adminEmployeeUserBean = new AdminEmployeeUserBean();
		adminEmployeeUserBean.setAddress("Mumbai");
		adminEmployeeUserBean.setContactNumber("9012345678");
		adminEmployeeUserBean.setName("Xyz Abcd");
		adminEmployeeUserBean.setNationality("Indian");
		adminEmployeeUserBean.setType("User");

		TestCase.assertNull(adminEmployeeUserDaoImpl.save(adminEmployeeUserBean));

	}

	@Test
	public void testCheckUserEmail() {
		TestCase.assertEquals(true, adminEmployeeUserDaoImpl.checkUserEmail("anjali@gmail.com"));
	}

	@Test
	public void testInvalidCheckUserEmail() {
		TestCase.assertEquals(false, adminEmployeeUserDaoImpl.checkUserEmail("anji@gmail.com"));
	}

	@Test
	public void testUpdateUserProfile() {
		AdminEmployeeUserBean userBean = new AdminEmployeeUserBean();
		userBean.setId(30);
		userBean.setEmail("anjali@gmail.com");
		userBean.setAddress("Indore");
		userBean.setContactNumber("9987648115");
		TestCase.assertNotNull(adminEmployeeUserDaoImpl.saveAndFlush(userBean));
	}

	@Test(expected = HotelManagementSystemException.class)
	public void testInvalidUpdateUserProfile() {
		AdminEmployeeUserBean userBean = new AdminEmployeeUserBean();
		userBean.setId(32);
		// userBean.setEmail("anjali@gmail.com");
		userBean.setAddress("Indore");
		userBean.setContactNumber("9987648115");
		TestCase.assertNull(adminEmployeeUserDaoImpl.saveAndFlush(userBean));
	}
}// End of AdminEmployeeUserTest()
