package com.revature.hotelmanagementsystem.service;

import com.revature.hotelmanagementsystem.bean.AdminEmployeeUserBean;

public interface AdminEmployeeUserService {

	public AdminEmployeeUserBean adminEmployeeUserLogin(String email, String password);

	public AdminEmployeeUserBean userRegister(AdminEmployeeUserBean adminEmployeeUserBean);

	public boolean checkUserEmail(String email);

	public AdminEmployeeUserBean userProfile(AdminEmployeeUserBean adminEmployeeUserBean);

	public AdminEmployeeUserBean updateUserProfile(AdminEmployeeUserBean adminEmployeeUserBean);

}// end of interface
