package com.hihihigh.crm.service;

import java.util.List;

import com.hihihigh.crm.model.CustomerFollowInfo;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopment;

public interface CustomerAdviceService {
	/**
	 * 查询所有客户信息
	 * @return 客户信息(多)
	 */
	List<Customer> selectVisitingCustomers();
	
	String addCustomerDevelopment(Integer customerId,String accountName);

	List<CustomerFollowInfo> selectCustomerFollowingInfo(String accountName);

	String alterRemark(Customer customer);

	String alterCustomerFollowInfo(Customer customer, CustomerDevelopment customerDevelopment);

}
