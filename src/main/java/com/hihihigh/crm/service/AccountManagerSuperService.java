package com.hihihigh.crm.service;

import java.util.List;

import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.Employee;

public interface AccountManagerSuperService {

	/**
	 * 删除管理员账号
	 * @param account 账号
	 * @return 0 添加成功 1 添加失败
	 */
	String deleteAdmin(List<Integer> accountIds,List<Integer> employeeIds);

	/**
	 * 查看所有员工信息
	 * @return 所有员工信息
	 */
	List<Account> selectAllAccounts();

	/**
	 * 查询所有`管理员`账号信息
	 * @return
	 */
	List<Account> selectAdminAccounts();

	/**
	 * 添加账号
	 * @param employee 员工信息
	 * @param account 账号信息
	 * @return
	 */
	String addAcccount(Employee employee, Account account);

}
