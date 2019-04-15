package com.hihihigh.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.jdbc.RuntimeSqlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.AccountMapper;
import com.hihihigh.crm.dao.EmployeeMapper;
import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.AccountExample;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.model.autogenerator.EmployeeExample;
import com.hihihigh.crm.model.autogenerator.EmployeeExample.Criteria;
import com.hihihigh.crm.service.AccountManagerSuperService;

@Service
@Transactional
public class AccountManagerSuperServiceImpl implements AccountManagerSuperService{
	private final static String SUCCESS = "0";
	private final static String FAILED = "1";
	
	@Autowired
	AccountMapper accountMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public String addAcccount(Employee employee, Account account) {
		int result = 0;
		try {
			result += employeeMapper.insertSelective(employee);
			account.setAccountEmployeeId(employee.getId());
			result += accountMapper.insertSelective(account);
		} catch (Exception e) {
			throw new RuntimeSqlException("手动模拟转账时出现异常");
		}
		
		return result==2 ? SUCCESS : FAILED;
	}

	@Override
	public String deleteAdmin(List<Integer> accountIds,List<Integer> employeeIds) {
		int result = 0;
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria accountCriteria = accountExample.createCriteria();
		accountCriteria.andIdIn(accountIds);
		result += accountMapper.deleteByExample(accountExample);
		EmployeeExample employeeExample = new EmployeeExample();
		EmployeeExample.Criteria employeeCriteria = employeeExample.createCriteria();
		employeeCriteria.andIdIn(employeeIds);
		result += employeeMapper.deleteByExample(employeeExample);
		return result == accountIds.size()+employeeIds.size()
				? SUCCESS : FAILED;
	}

	@Override
	public List<Account> selectAllAccounts() {
		AccountExample example = new AccountExample();
		return accountMapper.selectByExample(example);
	}

	@Override
	public List<Account> selectAdminAccounts() {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmployeePositionNameEqualTo("管理员");
		List<Employee> employees = employeeMapper.selectByExample(example);
		List<Account> accounts = new ArrayList<>();
		AccountExample example2 = new AccountExample();
		AccountExample.Criteria criteria2;
		for (Employee employee : employees) {
			example2.clear();
			criteria2 = example2.createCriteria();
			criteria2.andAccountEmployeeIdEqualTo(
					employee.getId());
			accounts.addAll(accountMapper.selectByExample(example2));
		}
		return accounts;
	}

}
