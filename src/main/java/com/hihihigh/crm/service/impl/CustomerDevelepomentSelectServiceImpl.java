package com.hihihigh.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.AccountMapper;
import com.hihihigh.crm.dao.CustomerDevelopmentBeforeMapper;
import com.hihihigh.crm.dao.CustomerMapper;
import com.hihihigh.crm.model.CustomerFollowInfo;
import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.AccountExample;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopmentBefore;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopmentBeforeExample;
import com.hihihigh.crm.service.CustomerDevelepomentSelectService;

@Service
@Transactional
public class CustomerDevelepomentSelectServiceImpl implements CustomerDevelepomentSelectService{
	private static final String SUCCESS = "0";
	private static final String FAILED = "1";
	
	@Autowired
	CustomerDevelopmentBeforeMapper cdbm;
	
	@Autowired
	AccountMapper accountMapper;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public List<CustomerFollowInfo> selectCustomerFollowingInfo(String accountName) {
		List<CustomerFollowInfo> customerFollowInfos =
				new ArrayList<>();
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria accountCriteria = accountExample.createCriteria();
		accountCriteria.andUsernameEqualTo(accountName);
		Account account = accountMapper.selectByExample(accountExample).get(0);
		
		CustomerDevelopmentBeforeExample customerDevelopmentBeforeExample =
				new CustomerDevelopmentBeforeExample();
		customerDevelopmentBeforeExample.createCriteria()
		.andCd0EmployeeIdEqualTo(account.getAccountEmployeeId());
		List<CustomerDevelopmentBefore> customerDevelopmentBefores = 
				cdbm.selectByExample(customerDevelopmentBeforeExample);
		
		for (CustomerDevelopmentBefore customerDevelopmentBefore : customerDevelopmentBefores) {
			Customer customer = customerMapper
					.selectByPrimaryKey(customerDevelopmentBefore
							.getCd0CustomerId());
			customerFollowInfos.add(
				new CustomerFollowInfo(customer,customerDevelopmentBefore));
		}
		return customerFollowInfos;
	}

	@Override
	public String alterCustomerFollowInfo(Customer customer, CustomerDevelopmentBefore customerDevelopmentBefore) {
		boolean result = false;
		if (customerMapper.updateByPrimaryKeySelective(customer)==1) {
			result = true;
		}
		if (result&&customerDevelopmentBefore.getNextContactTime()!=null) {
			if(cdbm.updateByPrimaryKeySelective(customerDevelopmentBefore)!=1){
				result = false;
			}
		}
		return result == true ? SUCCESS : FAILED;
	}

	@Override
	public String addCustomerInfo(Customer customer, String accountName) {
		int result = 0;
		customer.setCreateTime(new Date());
		result += customerMapper.insertSelective(customer);
		Integer customerId = customer.getId();
		
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria accountCriteria = accountExample.createCriteria();
		accountCriteria.andUsernameEqualTo(accountName);
		Account account = accountMapper.selectByExample(accountExample).get(0);
		CustomerDevelopmentBefore customerDevelopmentBefore = new CustomerDevelopmentBefore();
		customerDevelopmentBefore.setCd0EmployeeId(account.getAccountEmployeeId());
		customerDevelopmentBefore.setCd0AllocationTime(new Date());
		customerDevelopmentBefore.setCd0CustomerId(customerId);
		result += cdbm.insertSelective(customerDevelopmentBefore);
		return result == 2 ? SUCCESS : FAILED;
	}

}
