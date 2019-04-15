package com.hihihigh.crm.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public enum MyAuthorities implements GrantedAuthority,Serializable{
	ROLE_AUTHORITY_MANAGER,ROLE_ACCOUNT_MANAGER_SUPER,ROLE_REPORT_MANAGER_SUPER,
	ROLE_ACCOUNT_MANAGER_ADMIN,
	ROLE_CUSTOMER_ADVICE,ROLE_COUNT_DATA_COUNSELOR,
	ROLE_DEPARTMENT_MANAGER,
	ROLE_REPORT_MANAGER_INTERNET_COUNSELOR,ROLE_CUSTOMER_DEVELEPOMENT,ROLE_COUNT_DATA_DEVELOPMENT,
	ROLE_CUSTOMER_DEVELEPOMENT_SELECT,
	ROLE_ACCOUNT_MANAGER_ASSISTANT,ROLE_REPORT_MANAGER_ASSISTANT,ROLE_CUSTOMER_MATERIAL,
	ROLE_REPORT_MANAGER_SALESMAN;
	
	public static List<MyAuthorities> asList() {
		MyAuthorities[] all = MyAuthorities.values();
		return Arrays.asList(all);
	}

	@Override
	public String getAuthority() {
		return this.toString();
	}
}
