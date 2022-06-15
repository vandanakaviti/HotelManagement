package com.revature.hotelmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.hotelmanagementsystem.bean.BookingInformationBean;
import com.revature.hotelmanagementsystem.bean.HotelInformationBean;
import com.revature.hotelmanagementsystem.bean.RoomInformationBean;

@Repository
public interface BookingOperationDAO extends JpaRepository<BookingInformationBean, Integer>{

	
	@Query("from BookingInformationBean where email =:email")
	public List<BookingInformationBean> getBookingHistory(@Param("email") String email);

	
}
