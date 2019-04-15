package com.hihihigh.crm.service;

import java.util.List;

import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.Employee;

public interface ReportManagerSuperService {

	/**
	 * 按部门查询员工信息
	 * @param departmentId 部门编号
	 * @return 员工(多)
	 */
	List<Employee> selectEmployeeByCondition(String condition);

	/**
	 * 按条件模糊查询用户
	 * @param condition 查询的关键字
	 * @return 用户(多)
	 */
	List<Customer> selectCustomersByCondition(String condition);

}
