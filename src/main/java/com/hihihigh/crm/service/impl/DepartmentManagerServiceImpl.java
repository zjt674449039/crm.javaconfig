package com.hihihigh.crm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.service.DepartmentManagerService;

@Service
@Transactional
public class DepartmentManagerServiceImpl implements DepartmentManagerService{

	@Override
	public List<Employee> manage(String username) {
		
		return null;
	}

}
