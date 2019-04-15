package com.hihihigh.crm.service;

import com.hihihigh.crm.model.autogenerator.Customer;

public interface CustomerMaterialService {
	
	/**
	 * 添加指定客户信息
	 * @param customer 期待添加的客户信息
	 * @return 0 操作成功 1 操作失败
	 */
	String addCustomerInfo(Customer customer);

	/**
	 * 根据客户id,修改指定客户信息
	 * @param customer 期待修改的客户信息
	 * @return 0 操作成功 1 操作失败
	 */
	String alterCustomerInfo(Customer customer);

	String allotmentCustomerCustomer(Integer customerId, Integer employeeId);

	String allotmentCustomerToCounselor(Integer customerId, Integer employeeId);

}
