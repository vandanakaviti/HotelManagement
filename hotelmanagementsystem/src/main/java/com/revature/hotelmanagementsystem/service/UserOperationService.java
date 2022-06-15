package com.revature.hotelmanagementsystem.service;

import java.util.List;

import com.revature.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.revature.hotelmanagementsystem.bean.BookingInformationBean;
import com.revature.hotelmanagementsystem.bean.HotelInformationBean;
import com.revature.hotelmanagementsystem.bean.RoomInformationBean;

public interface UserOperationService {

	public List<RoomInformationBean> roomList(HotelInformationBean hotelInformationBean);

	public BookingInformationBean bookRoomUser(BookingInformationBean bookingInformationBean);

	public double calculateTotalDaysAmount(BookingInformationBean bookingInformationBean);

	public int updateRoomCount(int roomId);

	public String updateRoomStatus(int roomId);

	public List<BookingInformationBean> getBookingHistory(String email);

	public boolean cancelBooking(int bookingId);
}// end of interface
