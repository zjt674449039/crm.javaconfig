package com.hihihigh.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.EmployeeMapper;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.model.autogenerator.EmployeeExample;
import com.hihihigh.crm.model.autogenerator.EmployeeExample.Criteria;
import com.hihihigh.crm.service.AccountManagerAssistantService;

@Service
@Transactional
public class AccountManagerAssistantServiceImpl implements AccountManagerAssistantService{

	@Autowired
	EmployeeMapper employeeMapper;

	@Override
	public List<Employee> selectEmployeesByPositionName(String positionName) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmployeePositionNameEqualTo(positionName);
		return employeeMapper.selectByExample(example);
	}

}
