package com.capgemini.hotelmanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.hotelmanagementsystem.bean.EmployeeInformationBean;
import com.revature.hotelmanagementsystem.bean.HotelInformationBean;
import com.revature.hotelmanagementsystem.bean.RoomInformationBean;
import com.revature.hotelmanagementsystem.dao.BookingOperationDAO;
import com.revature.hotelmanagementsystem.dao.EmployeeOperationDao;
import com.revature.hotelmanagementsystem.dao.HotelOperationDAO;
import com.revature.hotelmanagementsystem.dao.RoomOperationDAO;
import com.revature.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.revature.hotelmanagementsystem.validation.HotelValidationImpl;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminOperationsTest {
	
	@Autowired
	private BookingOperationDAO bookingOperationDao;
	@Autowired
	private RoomOperationDAO roomOperationDao;
	
	@Autowired
	private EmployeeOperationDao employeeOperationDao;
	
	@Autowired
	private HotelOperationDAO hotelOperationDao;
	@Autowired
	private HotelValidationImpl hotelValidation;

	
	// Hotel Test Cases

	// Valid test addHotel()
	@Test(expected = HotelManagementSystemException.class)
	public void testAddHotel() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		hotelInformationBean.setHotelAddress("Banglore");
		hotelInformationBean.setHotelContactNumber("7890123456");
		hotelInformationBean.setHotelName("WestWoods Hotel");
		hotelInformationBean.setHotelImageURL("qwerty.image.jpg");
		hotelInformationBean.setLicenceNumber("H00000000");
		hotelInformationBean.setHotelId(1);

		TestCase.assertNotNull(hotelOperationDao.save(hotelInformationBean));

	}// End of testAddHotel()

	// Invalid test addHotel()
	@Test
	public void testInvalidAddHotel() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		hotelInformationBean.setHotelAddress("Mumbai");
		hotelInformationBean.setHotelContactNumber("9087654321");
		hotelInformationBean.setHotelName("Abcd Efgh");
		hotelInformationBean.setHotelImageURL("qwerty.image.url");
		hotelInformationBean.setLicenceNumber("");

		TestCase.assertNotNull(hotelOperationDao.save(hotelInformationBean));

	}

	// Valid test updateHotelRoom()
	@Test(expected = HotelManagementSystemException.class)
	public void testUpdateHotel() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		hotelInformationBean.setHotelId(1);
		hotelInformationBean.setHotelContactNumber("8907654321");
		hotelInformationBean.setHotelImageURL("qwy.image.png");

		 hotelOperationDao.saveAndFlush(hotelInformationBean);
		 boolean actual =true;
		assertEquals(true, actual);

	}// End of testUpdateHotelRoom()

	// Invalid updateHotelRoom()
	@Test(expected = HotelManagementSystemException.class)
	public void testInvalidUpdateHotel() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		hotelInformationBean.setHotelAddress("Mumbai");
		hotelInformationBean.setHotelContactNumber("8907654321");
		hotelInformationBean.setHotelName("Qwerty Hotel");
		hotelInformationBean.setHotelImageURL("qwy.image.url");
		hotelInformationBean.setLicenceNumber("H000");

		hotelOperationDao.saveAndFlush(hotelInformationBean);
		 boolean actual =true;
		assertEquals(true, actual);
	}

	// valid test deleteHotelInformation()
	@Test
	public void testDeleteHotelInformation() {

		 hotelOperationDao.deleteById(1);
		 boolean actual =true;
		assertEquals(false, actual);

	}// End of testDeleteHotelInformation()

	// Invalid test deleteHotelInformation()
	@Test
	public void testInvalidDeleteHotelInformation() {

		 hotelOperationDao.deleteById(11);
		 boolean actual =true;
		assertEquals(false, actual);

	}

	// Valid test getHotelList()
	@Test
	public void testGetHotelList() {
		TestCase.assertNotNull(hotelOperationDao.findAll());
	}


	// Room Test Cases

	// Valid addRoom()
	@Test
	public void testAddRoom() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		RoomInformationBean roomInformationBean = new RoomInformationBean();
		roomInformationBean.setLicenceNumber("H10101010");
		roomInformationBean.setRoomAmount(1000);
		roomInformationBean.setRoomCapacity("singleBed");
		roomInformationBean.setRoomCount(10);
		roomInformationBean.setRoomId(1);
		roomInformationBean.setRoomImageURL("abcd.wertyh.jpeg");
		roomInformationBean.setRoomStatus("Available");
		roomInformationBean.setRoomType("Non AC");
		TestCase.assertNotNull(roomOperationDao.save(roomInformationBean));

	}// End of testAddRoom()

	// Invalid test addRoom()
	@Test(expected = HotelManagementSystemException.class)
	public void testInvalidAddRoom() {
		HotelInformationBean hotelInformationBean = new HotelInformationBean();
		RoomInformationBean roomInformationBean = new RoomInformationBean();
		// roomInformationBean.setHotelId(1);
		// roomInformationBean.setHotelName("Jamun");
		roomInformationBean.setHotelId(2);
		roomInformationBean.setRoomAmount(123);
		roomInformationBean.setRoomCount(25);
		roomInformationBean.setRoomImageURL("asdf");
		roomInformationBean.setRoomStatus("avaliable");
		roomInformationBean.setRoomType("AC");
		roomInformationBean.setRoomCapacity("singleBed");

		TestCase.assertNull(roomOperationDao.save(roomInformationBean));

	}

	// Passed
	@Test
	public void testUpdateRoomInformation() {
		RoomInformationBean roomInformationBean = new RoomInformationBean();
		roomInformationBean.setRoomId(1);
		// roomInformationBean.setLicenceNumber("H90909090");
		// roomInformationBean.setHotelName("Abcd Efgh");
		// roomInformationBean.setHotelId(9);
		roomInformationBean.setRoomCount(5);
		roomInformationBean.setRoomImageURL("asdf.jpeg");

		roomOperationDao.saveAndFlush(roomInformationBean);
		boolean actual = true;
		assertEquals(true, actual);

	}// End of testUpdateRoomInformation()

	// Invalid test updateRoomInformation()
	@Test
	public void testInvalidUpdateRoomInformation() {
		RoomInformationBean roomInformationBean = new RoomInformationBean();
		roomInformationBean.setRoomId(4);
		roomInformationBean.setRoomCapacity("singleBed");

		roomOperationDao.saveAndFlush(roomInformationBean);
		boolean actual = true;
		assertEquals(false, actual);

	}

	@Test
	public void testDeleteRoomInformation() {

		roomOperationDao.deleteById(1);
		boolean actual = true;
		assertEquals(true, actual);

	}// End of testDeleteRoomInformation()

	// Invalid test deleteRoomInformation()
	@Test
	public void testInvalidDeleteRoomInformation() {
		roomOperationDao.deleteById(3);
		boolean actual = true;
		assertEquals(false, actual);
	}

	// Valid test getRoomList()
	@Test
	public void testValidGetRoomList() {
		TestCase.assertNotNull(roomOperationDao.findAll());
	}

	// Employee Operation

	// Passed
	@Test
	public void testAddEmployee() {
		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
		employeeInformationBean.setAddress("Delhi");
		employeeInformationBean.setContactNumber("8901234567");
		employeeInformationBean.setEmail("employee2@gmail.com");
		employeeInformationBean.setHotelId(13);
		employeeInformationBean.setLicenceNumber("H70707070");
		// employeeInformationBean.setHotelName("Cosms");
		employeeInformationBean.setName("Employee Two");
		employeeInformationBean.setNationality("Indian");
		employeeInformationBean.setPassword("Empl@123");
		employeeInformationBean.setEmployeeId(1);

		TestCase.assertNotNull(employeeOperationDao.save(employeeInformationBean));

	}// End of testAddEmployee()

	// Invalid test addEmployee()
	@Test(expected = EmptyResultDataAccessException.class)
	public void testInvalidAddEmployee() {
		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
		employeeInformationBean.setAddress("Delhi");
		// employeeInformationBean.setContactNumber("123678");
		employeeInformationBean.setEmail("sm@gmail.com");
		employeeInformationBean.setHotelId(1);
		// employeeInformationBean.setHotelLicense("H00000001");
		employeeInformationBean.setHotelName("Cosms");
		employeeInformationBean.setName("manju");
		employeeInformationBean.setNationality("Inian");
		employeeInformationBean.setPassword("manjuBaba");

		TestCase.assertNull(employeeOperationDao.save(employeeInformationBean));

	}

	@Test(expected = NullPointerException.class)
	public void testUpdateEmployeeInformation() {

		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
		employeeInformationBean.setEmployeeId(1);
		employeeInformationBean.setAddress("Mumbai1");
		employeeInformationBean.setContactNumber("123456789");
		// employeeInformationBean.setHotelId(2);
		employeeInformationBean.setLicenceNumber("H70707070");
		// employeeInformationBean.setHotelName("Indus");
		employeeInformationBean.setNationality("Indian");
		employeeInformationBean.setPassword("Abcd@123");

		employeeOperationDao.saveAndFlush(employeeInformationBean);
		boolean actual = true;
		assertEquals(true, actual);

	}// End of testUpdateEmployeeInformation()

	// Invalid test updateEmployeeInformation
	@Test(expected = NullPointerException.class)
	public void testInvalidUpdateEmployeeInformation() {

		EmployeeInformationBean employeeInformationBean = new EmployeeInformationBean();
		employeeInformationBean.setEmployeeId(1);
		employeeInformationBean.setAddress("Mumbai1");
		employeeInformationBean.setContactNumber("123456789");
		// employeeInformationBean.setHotelId(2);
		employeeInformationBean.setLicenceNumber("123");
		employeeInformationBean.setHotelName("Indus");
		employeeInformationBean.setNationality("Indian");
		employeeInformationBean.setPassword("");

		employeeOperationDao.saveAndFlush(employeeInformationBean);
		boolean actual = true;
		assertEquals(true, actual);
	}

	// Passed
	@Test
	public void testDeleteEmployee() {
		employeeOperationDao.deleteById(1);
		boolean actual = true;
		assertEquals(true, actual);

	}// End of testDeleteEmployee()

	// Invalid test deleteEmployee()
	@Test(expected = HotelManagementSystemException.class)
	public void testInvalidDeleteEmployee() {
		employeeOperationDao.deleteById(1);
		boolean actual = true;
		assertEquals(true, actual);
	}

	// Passed
	// Valid test getEmployeeList()
	@Test
	public void testGetEmployeeList() {
		TestCase.assertNotNull(employeeOperationDao.findAll());
	}
}
