package com.hihihigh.crm.service;

import java.util.List;

import com.hihihigh.crm.model.autogenerator.Account;

public interface AccountManagerAdminService {

	/**
	 * 增加普通用户账号
	 * @param account 账号信息
	 * @return 0 操作成功 1 操作失败
	 */
	String addTypicalAccount(Account account);

	/**
	 * 根据员工id,账号表删除普通用户账号,员工表employee_status改为1
	 * @param accountId 账号id
	 * @return 0 操作成功 1 操作失败
	 */
	String deleteTypicalAccount(List<Integer> accountIds,List<Integer> employeeIds);

	/**
	 * 根据员工id,重置用户账户密码为123456
	 * @param accountId 员工id
	 * @return 0 操作成功 1 操作失败
	 */
	String resetAccountPassword(int accountId);

}
