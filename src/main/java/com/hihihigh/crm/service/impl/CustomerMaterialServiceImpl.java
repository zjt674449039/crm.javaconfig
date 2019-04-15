package com.hihihigh.crm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.CustomerDevelopmentBeforeMapper;
import com.hihihigh.crm.dao.CustomerDevelopmentMapper;
import com.hihihigh.crm.dao.CustomerMapper;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopment;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopmentBefore;
import com.hihihigh.crm.service.CustomerMaterialService;

@Service
@Transactional
public class CustomerMaterialServiceImpl implements CustomerMaterialService{
	private static final String SUCCESS = "0";
	private static final String FAILED = "1";
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public String addCustomerInfo(Customer customer) {
		customer.setCreateTime(new Date());
		return customerMapper.insertSelective(customer) == 1 ?
				SUCCESS : FAILED;
	}

	@Override
	public String alterCustomerInfo(Customer customer) {
		return customerMapper.updateByPrimaryKeySelective(customer)==1 ?
				SUCCESS : FAILED;
	}

	@Autowired
	CustomerDevelopmentBeforeMapper customerDevelopmentBeforeMapper;
	
	@Override
	public String allotmentCustomerCustomer(Integer customerId, Integer employeeId) {
		CustomerDevelopmentBefore cdb = new CustomerDevelopmentBefore();
		cdb.setCd0CustomerId(customerId);
		cdb.setCd0EmployeeId(employeeId);
		cdb.setCd0AllocationTime(new Date());
		return customerDevelopmentBeforeMapper.insertSelective(cdb) == 1 ?
				SUCCESS : FAILED;
	}

	@Autowired
	CustomerDevelopmentMapper customerDevelopmentMapper;
	
	@Override
	public String allotmentCustomerToCounselor(Integer customerId, Integer employeeId) {
		int result = 0;
		CustomerDevelopment cd = new CustomerDevelopment();
		cd.setCdCustomerId(customerId);
		cd.setCdEmployeeId(employeeId);
		cd.setAllocationTime(new Date());
		result += customerDevelopmentMapper.insertSelective(cd);
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setCustmerStatusCustomerId(2);
		result += customerMapper.updateByPrimaryKeySelective(customer);
		return result == 2 ? SUCCESS : FAILED;
	}

}
