package com.hihihigh.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.AccountMapper;
import com.hihihigh.crm.dao.AuthorityMapper;
import com.hihihigh.crm.dao.CustomerMapper;
import com.hihihigh.crm.dao.DepartmentMapper;
import com.hihihigh.crm.dao.EmployeeMapper;
import com.hihihigh.crm.dao.NameAuthorityMapper;
import com.hihihigh.crm.dao.PositionMapper;
import com.hihihigh.crm.dao.StatusCustmerMapper;
import com.hihihigh.crm.model.AccountInfo;
import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.AccountExample;
import com.hihihigh.crm.model.autogenerator.Authority;
import com.hihihigh.crm.model.autogenerator.AuthorityExample;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.CustomerExample;
import com.hihihigh.crm.model.autogenerator.Department;
import com.hihihigh.crm.model.autogenerator.DepartmentExample;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.model.autogenerator.EmployeeExample;
import com.hihihigh.crm.model.autogenerator.NameAuthority;
import com.hihihigh.crm.model.autogenerator.NameAuthorityExample;
import com.hihihigh.crm.model.autogenerator.NameAuthorityExample.Criteria;
import com.hihihigh.crm.model.autogenerator.Position;
import com.hihihigh.crm.model.autogenerator.PositionExample;
import com.hihihigh.crm.model.autogenerator.StatusCustmer;
import com.hihihigh.crm.model.autogenerator.StatusCustmerExample;
import com.hihihigh.crm.service.InfoService;

@Service
@Transactional
public class InfoServiceImpl implements InfoService{

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Override
	public List<Department> selectAllDepartmentInfo() {
		DepartmentExample example = new DepartmentExample();
		return departmentMapper.selectByExample(example);
	}

	@Autowired
	NameAuthorityMapper nameAuthorityMapper;
	
	@Override
	public List<NameAuthority> selectAllNameAuthorityInfo() {
		NameAuthorityExample example = new NameAuthorityExample();
		return nameAuthorityMapper.selectByExample(example);
	}

	@Autowired
	PositionMapper positionMapper;
	
	@Override
	public List<Position> selectAllPositionInfo() {
		PositionExample example = new PositionExample();
		return positionMapper.selectByExample(example);
	}


	@Override
	public List<Position> selectAllPositionInfoUnAdmin() {
		PositionExample example = new PositionExample();
		PositionExample.Criteria criteria = example.createCriteria();
		criteria.andPositionNameNotEqualTo("管理员")
		.andPositionNameNotEqualTo("超级管理员");
		return positionMapper.selectByExample(example);
	}
	
	@Autowired
	AuthorityMapper authorityMapper;
	
	@Override
	public List<NameAuthority> selectAuthorityByPositionId(int positionId) {
		AuthorityExample authorityExample = new AuthorityExample();
		AuthorityExample.Criteria authorityCriteria = authorityExample.createCriteria();
		authorityCriteria.andAuthorityPositionIdEqualTo(positionId);
		List<Authority> authorities = authorityMapper.selectByExample(authorityExample);
		List<Integer> authoritiyIds = new ArrayList<>();
		for (Authority authority : authorities) {
			authoritiyIds.add(authority.getAuthorityNameAuthorityId());
		}
		NameAuthorityExample nameAuthorityExample = new NameAuthorityExample();
		Criteria nameAuthorityCriteria = nameAuthorityExample.createCriteria();
		nameAuthorityCriteria.andIdIn(authoritiyIds);
		return nameAuthorityMapper.selectByExample(nameAuthorityExample);
	}
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	AccountMapper accountMapper;

	@Override
	public List<AccountInfo> selectAccountAndEmployeeInfoByTypeAccount(String typeAccount) {
		List<AccountInfo> accountInfos = new ArrayList<>();
		EmployeeExample employeeExample = new EmployeeExample();
		EmployeeExample.Criteria employeeCriteria = employeeExample.createCriteria();
		employeeCriteria.andEmployeePositionNameEqualTo(typeAccount);
		List<Employee> employees = employeeMapper.selectByExample(employeeExample);
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria accountCriteria = accountExample.createCriteria();
		for (Employee employee : employees) {
			accountExample.clear();
			accountCriteria = accountExample.createCriteria();
			accountCriteria.andAccountEmployeeIdEqualTo(employee.getId());
			List<Account> accounts = accountMapper.selectByExample(accountExample);
			Account account;
			if (accounts.size()==1) {
				account = accounts.get(0);
			}else {
				continue;
			}
			accountInfos.add(new AccountInfo(account,employee));
		}
		return accountInfos;
	}

	@Override
	public List<AccountInfo> selectAllAccountAndEmployeeInfo() {
		List<AccountInfo> accountInfos = new ArrayList<>();
		EmployeeExample employeeExample = new EmployeeExample();
		List<Employee> employees = employeeMapper.selectByExample(employeeExample);
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria accountCriteria = accountExample.createCriteria();
		for (Employee employee : employees) {
			accountExample.clear();
			accountCriteria = accountExample.createCriteria();
			accountCriteria.andAccountEmployeeIdEqualTo(employee.getId());
			Account account;
			List<Account> accounts = accountMapper.selectByExample(accountExample);
			if (accounts.size()>0) {
				account	= accounts.get(0);
			}else {
				account = new Account();
			}
			accountInfos.add(new AccountInfo(account,employee));
		}
		return accountInfos;
	}

	@Override
	public List<AccountInfo> selectAccountAndEmployeeUnAdmin() {
		List<AccountInfo> accountInfos = new ArrayList<>();
		EmployeeExample employeeExample = new EmployeeExample();
		EmployeeExample.Criteria employeeCriteria = employeeExample.createCriteria();
		employeeCriteria.andEmployeePositionNameNotEqualTo("管理员")
		.andEmployeePositionNameNotEqualTo("超级管理员")
		.andEmployeeStatusEqualTo(0);
		List<Employee> employees = employeeMapper.selectByExample(employeeExample);
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria accountCriteria = accountExample.createCriteria();
		for (Employee employee : employees) {
			accountExample.clear();
			accountCriteria = accountExample.createCriteria();
			accountCriteria.andAccountEmployeeIdEqualTo(employee.getId());
			Account account = accountMapper.selectByExample(accountExample).get(0);
			accountInfos.add(new AccountInfo(account,employee));
		}
		return accountInfos;
	}

	@Autowired
	StatusCustmerMapper statusCustmerMapper;
	
	@Override
	public List<StatusCustmer> selectAllStatusCustomers() {
		StatusCustmerExample statusCustmerExample = new StatusCustmerExample();
		return statusCustmerMapper.selectByExample(statusCustmerExample);
	}


	@Override
	public List<StatusCustmer> selectcustomerStatusOnNewBuilt() {
		StatusCustmerExample statusCustmerExample = new StatusCustmerExample();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(6);
		statusCustmerExample.createCriteria().andIdIn(ids);
		return statusCustmerMapper.selectByExample(statusCustmerExample);
	}

	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public List<Customer> selectcustomerInfo() {
		CustomerExample customerExample = new CustomerExample();
		return customerMapper.selectByExample(customerExample);
	}


	@Override
	public List<Customer> selectCustomerForTmkInfo() {
		CustomerExample customerExample = new CustomerExample();
		customerExample.createCriteria().andCustmerStatusCustomerIdEqualTo(1);
		return customerMapper.selectByExample(customerExample);
	}


	@Override
	public List<Employee> selectTmkEmployee() {
		EmployeeExample employeeExample = new EmployeeExample();
		employeeExample.createCriteria().andEmployeePositionNameEqualTo("电销员工");
		return employeeMapper.selectByExample(employeeExample);
	}


	@Override
	public List<Customer> selectCustomerForCounselorInfo() {
		CustomerExample customerExample = new CustomerExample();
		customerExample.createCriteria().andCustmerStatusCustomerIdEqualTo(6);
		return customerMapper.selectByExample(customerExample);
	}


	@Override
	public List<Employee> selectCounselorEmployee() {
		EmployeeExample employeeExample = new EmployeeExample();
		employeeExample.createCriteria().andEmployeePositionNameEqualTo("咨询师");
		return employeeMapper.selectByExample(employeeExample);
	}


}
