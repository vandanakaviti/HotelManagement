package com.revature.hotelmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.revature.hotelmanagementsystem.bean.BookingInformationBean;
import com.revature.hotelmanagementsystem.bean.EmployeeInformationBean;
import com.revature.hotelmanagementsystem.bean.HotelInformationBean;
import com.revature.hotelmanagementsystem.bean.RoomInformationBean;

@Repository
public interface EmployeeOperationDao extends JpaRepository<EmployeeInformationBean, Integer>{

	@Query("update RoomInformationBean set roomCount = roomCount-1 where roomId = : roomId")
	public BookingInformationBean bookUser(@Param("roomId") int roomId);
	
	@Query("from EmployeeInformationBean where email=:email")
	public EmployeeInformationBean getByEmail(@Param("email") String email);

}// end of interface
