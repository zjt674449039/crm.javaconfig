package com.hihihigh.crm.service;

import java.util.List;

import com.hihihigh.crm.model.CustomerFollowInfo;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopmentBefore;

public interface CustomerDevelepomentSelectService {

	List<CustomerFollowInfo> selectCustomerFollowingInfo(String accountName);

	String alterCustomerFollowInfo(Customer customer, CustomerDevelopmentBefore customerDevelopmentBefore);

	String addCustomerInfo(Customer customer, String accountName);

}
