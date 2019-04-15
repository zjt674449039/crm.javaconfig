package com.hihihigh.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.CustomerMapper;
import com.hihihigh.crm.dao.EmployeeMapper;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.CustomerExample;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.model.autogenerator.EmployeeExample;
import com.hihihigh.crm.model.autogenerator.EmployeeExample.Criteria;
import com.hihihigh.crm.service.ReportManagerSuperService;

@Service
@Transactional
public class ReportManagerSuperServiceImpl implements ReportManagerSuperService{
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public List<Employee> selectEmployeeByCondition(String condition) {
		EmployeeExample example = new EmployeeExample();
		Criteria nameCriteria = example.createCriteria();
		nameCriteria.andEmployeeNameLike("%"+condition+"%");
		Criteria positionCriteria = example.createCriteria();
		positionCriteria.andEmployeePositionNameLike("%"+condition+"%");
		example.or(positionCriteria);
		Criteria cellphoneCriteria = example.createCriteria();
		cellphoneCriteria.andEmployeeCellphoneLike("%"+condition+"%");
		example.or(cellphoneCriteria);
		List<Employee> employees = employeeMapper.selectByExample(example);
		return employees;
	}

	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public List<Customer> selectCustomersByCondition(String condition) {
		CustomerExample example = new CustomerExample();
		//姓名模糊查询
		CustomerExample.Criteria nameCriteria = 
				example.createCriteria();
		nameCriteria.andCustomerNameLike("%"+condition+"%");
		//学历模糊查询
		CustomerExample.Criteria educationalLevelCriteria = 
				example.createCriteria();
		educationalLevelCriteria.andEducationalLevelLike(
				"%"+condition+"%");
		example.or(educationalLevelCriteria);
		//电话模糊查询
		CustomerExample.Criteria telephoneCriteria = 
				example.createCriteria();
		telephoneCriteria.andCustomerTelephoneLike(
				"%"+condition+"%");
		example.or(telephoneCriteria);
		//备注模糊查询
		CustomerExample.Criteria remarkCriteria = 
				example.createCriteria();
		remarkCriteria.andCustomerRemarkLike(
				"%"+condition+"%");
		example.or(remarkCriteria);
		return customerMapper.selectByExample(example);
	}

}
