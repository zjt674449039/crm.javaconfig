package com.hihihigh.crm.service;

import java.util.List;

import com.hihihigh.crm.model.autogenerator.Employee;

public interface AccountManagerAssistantService {

	/**
	 * 
	 * @param string
	 * @return
	 */
	List<Employee> selectEmployeesByPositionName(String positionName);

}
