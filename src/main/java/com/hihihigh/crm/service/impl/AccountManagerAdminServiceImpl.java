package com.hihihigh.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.AccountMapper;
import com.hihihigh.crm.dao.EmployeeMapper;
import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.AccountExample;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.model.autogenerator.EmployeeExample;
import com.hihihigh.crm.service.AccountManagerAdminService;

@Service
@Transactional
public class AccountManagerAdminServiceImpl implements AccountManagerAdminService{
	private static final String SUCCESS = "0";
	private static final String FAILED = "1";
	
	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public String addTypicalAccount(Account account) {
		return accountMapper.insertSelective(account) == 1 ?
				SUCCESS:FAILED;
	}

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public String deleteTypicalAccount(List<Integer> accountIds,List<Integer> employeeIds) {
		int result = 0;
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria accountCriteria = accountExample.createCriteria();
		accountCriteria.andIdIn(accountIds);
		result += accountMapper.deleteByExample(accountExample);
		EmployeeExample employeeExample = new EmployeeExample();
		EmployeeExample.Criteria employeeCriteria = employeeExample.createCriteria();
		employeeCriteria.andIdIn(employeeIds);
		Employee employee = new Employee();
		employee.setEmployeeStatus(1);
		result += employeeMapper.updateByExampleSelective(employee, employeeExample);
		return result == accountIds.size()+employeeIds.size()
				? SUCCESS : FAILED;
	}

	@Override
	public String resetAccountPassword(int accountId) {
		Account account = new Account();
		account.setId(accountId);
		account.setPassword("123456");
		return accountMapper.updateByPrimaryKeySelective(account) ==1 ?
				SUCCESS : FAILED;
	}

}
