package com.revature.hotelmanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.hotelmanagementsystem.bean.HotelInformationBean;

@Repository
public interface HotelOperationDAO extends JpaRepository<HotelInformationBean, Integer>{
	
	@Query("from HotelInformationBean where licenceNumber=:licenceNumber")
	public HotelInformationBean hotelInformation(@Param("licenceNumber") String licenseNumber);
}
