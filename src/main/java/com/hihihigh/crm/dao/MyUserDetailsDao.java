package com.hihihigh.crm.dao;

import com.hihihigh.crm.model.MyUserDetails;

public interface MyUserDetailsDao {

	MyUserDetails selectUserByUsername(String username);
	
}
