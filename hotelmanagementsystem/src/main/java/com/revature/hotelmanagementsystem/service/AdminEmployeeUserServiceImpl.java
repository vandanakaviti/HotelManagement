package com.revature.hotelmanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hotelmanagementsystem.bean.AdminEmployeeUserBean;
import com.revature.hotelmanagementsystem.dao.AdminEmployeeUserDao;
import com.revature.hotelmanagementsystem.exception.HotelManagementSystemException;
import com.revature.hotelmanagementsystem.validation.HotelValidation;

@Service
public class AdminEmployeeUserServiceImpl implements AdminEmployeeUserService {

	@Autowired
	private AdminEmployeeUserDao adminEmployeeUserDao;

	@Autowired
	private HotelValidation validation;

	@Override
	public AdminEmployeeUserBean adminEmployeeUserLogin(String email, String password) {
		AdminEmployeeUserBean adminEmployeeUserBean=null;
		if (validation.emailValidation(email)) {
			adminEmployeeUserBean = (AdminEmployeeUserBean) adminEmployeeUserDao.adminEmployeeUserLogin(email);
			if(adminEmployeeUserBean.getPassword().equals(password)) {
				return adminEmployeeUserBean;
			}
			return adminEmployeeUserBean;
		} else {
			throw new HotelManagementSystemException("Email must be in abc@gmail.com format");
		} // End of else for email	
		}// end of adminEmployeeUserLogin

	@Override
	public AdminEmployeeUserBean userRegister(AdminEmployeeUserBean adminEmployeeUserBean) {
		String email = adminEmployeeUserBean.getEmail();
		String password = adminEmployeeUserBean.getPassword();
		String contactNumber = adminEmployeeUserBean.getContactNumber();
		if (validation.emailValidation(email)) {
			if (validation.passwordValidation(password)) {
				if (validation.contactNumberValidation(contactNumber)) {
					adminEmployeeUserDao.save(adminEmployeeUserBean);
					return adminEmployeeUserBean;
				} else {
					throw new HotelManagementSystemException(
							"Contact Number first Integer must be between [7-9] and rest as follow");
				} // End of contactNumber else
			} else {
				throw new HotelManagementSystemException("Invalid Credentials for password");
			} // End of else for password
		} else {
			throw new HotelManagementSystemException("Email must be in abc@gmail.com format");
		} // End of else for email
	}// end of userRegister()

	@Override
	public boolean checkUserEmail(String email) {

		if (validation.emailValidation(email)) {
			AdminEmployeeUserBean adminEmployeeUserBean=adminEmployeeUserDao.checkUserEmail(email);
			if(adminEmployeeUserBean!=null) {
				return true;
			}
		} else {
			throw new HotelManagementSystemException("Email must be in abc@gmail.com format");
		} 
		return false;// End of else for email
	}// end of checkUserEmail

	@Override
	public AdminEmployeeUserBean userProfile(AdminEmployeeUserBean adminEmployeeUserBean) {
		int id = adminEmployeeUserBean.getId();
		System.out.println(id);
		String idUser = Integer.toString(id);
		System.out.println(idUser);
		if (validation.idValidation(idUser)) {
			Optional<AdminEmployeeUserBean> cc=adminEmployeeUserDao.findById(id);
			return cc.get();
		} else {
			throw new HotelManagementSystemException("Enter Proper Id");
		} // End of else
	}

	@Override
	public AdminEmployeeUserBean updateUserProfile(AdminEmployeeUserBean adminEmployeeUserBean) {
		int id = adminEmployeeUserBean.getId();
		String idUser = Integer.toString(id);
		String email = adminEmployeeUserBean.getEmail();
		String password = adminEmployeeUserBean.getPassword();
		String contactNumber = adminEmployeeUserBean.getContactNumber();
		String name = adminEmployeeUserBean.getName();
		if (validation.idValidation(idUser)) {
			if (validation.emailValidation(email)) {
				if (validation.passwordValidation(password)) {
					if (validation.contactNumberValidation(contactNumber)) {
						if (validation.nameValidation(name)) {
							return adminEmployeeUserDao.saveAndFlush(adminEmployeeUserBean);
						} else {
							throw new HotelManagementSystemException("Name must be in abc efg format");
						}// End of name else
					} else {
						throw new HotelManagementSystemException(
								"Contact Number first Integer must be between [7-9] and rest as follow");
					}// End of contactNumber else
				} else {
					throw new HotelManagementSystemException("Invalid Credentials for password");
				}// End of else for password
			} else {
				throw new HotelManagementSystemException("Email must be in abc@gmail.com format");
			}// End of else for email
		} else {
			throw new HotelManagementSystemException("Enter Proper Id");
		}// End of else for id
	}

}// end of class
