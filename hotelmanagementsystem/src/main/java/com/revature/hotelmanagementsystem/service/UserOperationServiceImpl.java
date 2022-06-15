package com.revature.hotelmanagementsystem.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotelmanagementsystem.bean.BookingInformationBean;
import com.revature.hotelmanagementsystem.bean.HotelInformationBean;
import com.revature.hotelmanagementsystem.bean.RoomInformationBean;
import com.revature.hotelmanagementsystem.dao.BookingOperationDAO;
import com.revature.hotelmanagementsystem.dao.RoomOperationDAO;
import com.revature.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.revature.hotelmanagementsystem.validation.HotelValidationImpl;

@Service
public class UserOperationServiceImpl implements UserOperationService {

	@Autowired
	private BookingOperationDAO bookingOperationDao;
	@Autowired
	private RoomOperationDAO roomOperationDao;
	@Autowired
	private HotelValidationImpl hotelValidation;

	@Override
	public List<RoomInformationBean> roomList(HotelInformationBean hotelInformationBean) {
		return roomOperationDao.roomList(hotelInformationBean.getLicenceNumber());
	}

	@Override
	public BookingInformationBean bookRoomUser(BookingInformationBean bookingInformationBean) {

		System.out.println("book room for user ");
		bookingOperationDao.save(bookingInformationBean);
		return bookingInformationBean;

	}

	@Override
	public double calculateTotalDaysAmount(BookingInformationBean bookingInformationBean) {
		if (hotelValidation.dateValidation(bookingInformationBean.getCheckInDate(),
				bookingInformationBean.getCheckOutDate())) {
			Date checkIn = bookingInformationBean.getCheckInDate();
			Date checkOut = bookingInformationBean.getCheckOutDate();
			double roomAmount = bookingInformationBean.getBookingAmount();
			double totalBill = 0;
			double noOfDays = 0;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");
			long difference = checkOut.getTime() - checkIn.getTime();
			noOfDays = (difference / (1000 * 60 * 60 * 24));
			totalBill = (noOfDays + 1) * roomAmount;
			return totalBill;
		} else {
			throw new HotelManagementSystemException("Enter valid check-in check-out date");
		}
	}

	@Override
	public int updateRoomCount(int roomId) {
		int updatedRoomCount = 0;
		Optional<RoomInformationBean> dd=roomOperationDao.findById(roomId);
		RoomInformationBean roomInformationBean = dd.get();
		boolean isUpdated = false;
		if (roomInformationBean != null) {
			int roomCount = roomInformationBean.getRoomCount();
			if (roomCount != 0) {
				updatedRoomCount = roomCount - 1;
				roomInformationBean.setRoomCount(updatedRoomCount);
				roomOperationDao.saveAndFlush(roomInformationBean);
				
				isUpdated = true;
				System.out.println(".....................updateRoomCount" + updatedRoomCount);
			}
		}
		return updatedRoomCount;
	}

	@Override
	public String updateRoomStatus(int roomId) {
		String updatedRoomStatus = null;
		Optional<RoomInformationBean> dd=roomOperationDao.findById(roomId);
		RoomInformationBean roomInformationBean = dd.get();
		boolean isUpdated = false;
		if (roomInformationBean != null) {
			String roomStatus = roomInformationBean.getRoomStatus();
			if (roomStatus != null) {
				updatedRoomStatus = "Not Available";
				roomInformationBean.setRoomStatus(updatedRoomStatus);
				
				roomOperationDao.saveAndFlush(roomInformationBean);
				
				isUpdated = true;
				System.out.println(".....................updatedRoomStatus" + updatedRoomStatus);
			}
		}
		return updatedRoomStatus;
	}

	@Override
	public List<BookingInformationBean> getBookingHistory(String email) {
		System.out.println(email+"  new service");
		return bookingOperationDao.getBookingHistory(email);
	}

	@Override
	public boolean cancelBooking(int bookingId) {
		bookingOperationDao.deleteById(bookingId);
		return true;
	}
}
