package com.revature.hotelmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.hotelmanagementsystem.bean.AdminEmployeeUserBean;
@Repository
public interface AdminEmployeeUserDao extends JpaRepository<AdminEmployeeUserBean, Integer>{

	@Query("from AdminEmployeeUserBean where email = :email")
	public AdminEmployeeUserBean adminEmployeeUserLogin(@Param("email") String email);

	@Query("from AdminEmployeeUserBean where email = :email")
	public AdminEmployeeUserBean checkUserEmail(@Param("email") String email);
	
	
}// end of interface
