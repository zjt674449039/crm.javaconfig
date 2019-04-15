package com.hihihigh.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.AccountMapper;
import com.hihihigh.crm.dao.CustomerDevelopmentMapper;
import com.hihihigh.crm.dao.CustomerMapper;
import com.hihihigh.crm.model.CustomerFollowInfo;
import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.AccountExample;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopment;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopmentExample;
import com.hihihigh.crm.model.autogenerator.CustomerExample;
import com.hihihigh.crm.model.autogenerator.CustomerExample.Criteria;
import com.hihihigh.crm.service.CustomerAdviceService;

@Service
@Transactional
public class CustomerAdviceServiceImpl implements CustomerAdviceService{
	private static final String SUCCESS = "0";
	private static final String FAILED = "1";
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public List<Customer> selectVisitingCustomers() {
		CustomerExample customerExample = new CustomerExample();
		Criteria customerCriteria = customerExample.createCriteria();
		customerCriteria.andCustmerStatusCustomerIdEqualTo(6);
		return customerMapper.selectByExample(customerExample);
	}


	@Autowired
	AccountMapper accountMapper;
	
	@Autowired
	CustomerDevelopmentMapper customerDevelopmentMapper;
	
	@Override
	public String addCustomerDevelopment(Integer customerId,String accountName) {
		int result = 0;
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria accountCriteria = accountExample.createCriteria();
		accountCriteria.andUsernameEqualTo(accountName);
		Account account = accountMapper.selectByExample(accountExample).get(0);
		CustomerDevelopment customerDevelopment = new CustomerDevelopment();
		customerDevelopment.setCdEmployeeId(account.getAccountEmployeeId());
		customerDevelopment.setAllocationTime(new Date());
		customerDevelopment.setCdCustomerId(customerId);
		result += customerDevelopmentMapper.insertSelective(customerDevelopment);
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setCustmerStatusCustomerId(2);
		result += customerMapper.updateByPrimaryKeySelective(customer);
		return result == 2 ? SUCCESS : FAILED;
	}

	@Override
	public List<CustomerFollowInfo> selectCustomerFollowingInfo(String accountName) {
		List<CustomerFollowInfo> customerFollowInfos =
				new ArrayList<>();
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria accountCriteria = accountExample.createCriteria();
		accountCriteria.andUsernameEqualTo(accountName);
		Account account = accountMapper.selectByExample(accountExample).get(0);
		
		CustomerDevelopmentExample customerDevelopmentExample =
				new CustomerDevelopmentExample();
		customerDevelopmentExample.createCriteria()
		.andCdEmployeeIdEqualTo(account.getAccountEmployeeId());
		List<CustomerDevelopment> customerDevelopments = 
			customerDevelopmentMapper.selectByExample(customerDevelopmentExample);
		
		for (CustomerDevelopment customerDevelopment : customerDevelopments) {
			Customer customer = customerMapper
					.selectByPrimaryKey(customerDevelopment
							.getCdCustomerId());
			customerFollowInfos.add(
				new CustomerFollowInfo(customer,customerDevelopment));
		}
		return customerFollowInfos;
	}

	@Override
	public String alterRemark(Customer customer) {
		return customerMapper.updateByPrimaryKeySelective(customer) == 1 
				? SUCCESS : FAILED;
	}

	@Override
	public String alterCustomerFollowInfo(Customer customer, CustomerDevelopment customerDevelopment) {
		boolean result = false;
		if (customerMapper.updateByPrimaryKeySelective(customer)==1) {
			result = true;
		}
		if (result&&customerDevelopment.getNextContactTime()!=null) {
			if(customerDevelopmentMapper.
					updateByPrimaryKeySelective(customerDevelopment)!=1){
				result = false;
			}
		}
		return result == true ? SUCCESS : FAILED;
	}
	
}
