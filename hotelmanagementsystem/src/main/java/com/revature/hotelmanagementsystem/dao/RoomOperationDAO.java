package com.revature.hotelmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.hotelmanagementsystem.bean.HotelInformationBean;
import com.revature.hotelmanagementsystem.bean.RoomInformationBean;

@Repository
public interface RoomOperationDAO extends JpaRepository<RoomInformationBean, Integer>{
	@Query("from RoomInformationBean where licenceNumber=:licenceNumber")
	public List<RoomInformationBean> roomList(@Param("licenceNumber") String licenceNumber);

	
}
