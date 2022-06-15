package com.revature.hotelmanagementsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.revature.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.revature.hotelmanagementsystem.response.HotelManagementResponse;

@RestControllerAdvice
public class HotelManagementSystemAdvice {
	
	@ExceptionHandler(HotelManagementSystemException.class)
	public HotelManagementResponse hotelManagementErrorResponse(HotelManagementSystemException e) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(400);
		hotelManagementResponse.setMessage("Failure");
		hotelManagementResponse.setDescription(e.getMessage());
		return hotelManagementResponse;
	}//End of hotelManagementErrorResponse()

}//End of HotelManagementSystemAdvice
