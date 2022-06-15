package com.revature.hotelmanagementsystem.service;

import java.util.List;

import com.revature.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.revature.hotelmanagementsystem.bean.BookingInformationBean;
import com.revature.hotelmanagementsystem.bean.HotelInformationBean;
import com.revature.hotelmanagementsystem.bean.RoomInformationBean;

public interface EmployeeOperationService {

	public List<RoomInformationBean> getRoomList(AdminEmployeeUserBean adminEmployeeUserBean);

	public HotelInformationBean getHotelInformation(AdminEmployeeUserBean adminEmployeeUserBean);

	public BookingInformationBean bookUser(BookingInformationBean bookingInformationBean);
}// end of interface
