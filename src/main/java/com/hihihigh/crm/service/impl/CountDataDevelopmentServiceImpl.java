package com.hihihigh.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.AccountMapper;
import com.hihihigh.crm.dao.CustomerDevelopmentBeforeMapper;
import com.hihihigh.crm.dao.CustomerMapper;
import com.hihihigh.crm.dao.EmployeeMapper;
import com.hihihigh.crm.model.CountData;
import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.AccountExample;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopmentBefore;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopmentBeforeExample;
import com.hihihigh.crm.model.autogenerator.CustomerExample;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.model.autogenerator.EmployeeExample;
import com.hihihigh.crm.service.CountDataDevelopmentService;

@Service
@Transactional
public class CountDataDevelopmentServiceImpl implements CountDataDevelopmentService{

	@Autowired
	AccountMapper accountMapper;
	
	@Autowired
	CustomerDevelopmentBeforeMapper cdbm;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public List<CountData> countDataDevelopment(String accountName) {
		List<CountData> countDataCounselors =
				new ArrayList<>();
		List<Employee> employees = selectEmployeeIdsByAccountName(accountName);
		for (Employee employee : employees) {
			CustomerDevelopmentBeforeExample customerDevelopmentBeforeExample =
					new CustomerDevelopmentBeforeExample();
			customerDevelopmentBeforeExample.createCriteria()
			.andCd0EmployeeIdEqualTo(employee.getId());
			List<CustomerDevelopmentBefore> customerDevelopmentBefores = 
					cdbm.selectByExample(customerDevelopmentBeforeExample);
			if (customerDevelopmentBefores.size()==0) {
				continue;
			}
			List<Integer> customerIds = new ArrayList<>();
			for (CustomerDevelopmentBefore customerDevelopmentBefore : customerDevelopmentBefores) {
				customerIds.add(customerDevelopmentBefore.getCd0CustomerId());
			}
			CustomerExample customerExample = new CustomerExample();
			List<Integer> countNumbers = new ArrayList<>();
			for(int i = 1 ; i <= 5 ; i++){
				customerExample.clear();
				customerExample.createCriteria()
				.andIdIn(customerIds)
				.andCustmerStatusCustomerIdEqualTo(i);
				countNumbers.add(
						customerMapper.countByExample(customerExample));
			}
			countDataCounselors.add(new CountData(employee,countNumbers));
		}
		return countDataCounselors;
	}
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	public List<Employee> selectEmployeeIdsByAccountName(String accountName){
		List<Employee> employees = new ArrayList<>();
		AccountExample accountExample = new AccountExample();
		AccountExample.Criteria accountCriteria = accountExample.createCriteria();
		accountCriteria.andUsernameEqualTo(accountName);
		Account account = accountMapper.selectByExample(accountExample).get(0);
		Employee employee = 
				employeeMapper.selectByPrimaryKey(account.getAccountEmployeeId());
		if ("咨询师主管".equals(employee.getEmployeePositionName())) {
			EmployeeExample employeeExample = new EmployeeExample();
			employeeExample.createCriteria().andEmployeePositionNameEqualTo("咨询师");
			employees = 
					employeeMapper.selectByExample(employeeExample);
		}else if("网络咨询主管".equals(employee.getEmployeePositionName())){
			EmployeeExample employeeExample = new EmployeeExample();
			employeeExample.createCriteria().andEmployeePositionNameEqualTo("网络咨询员工");
			employees = 
					employeeMapper.selectByExample(employeeExample);
		}else if("电销主管".equals(employee.getEmployeePositionName())){
			EmployeeExample employeeExample = new EmployeeExample();
			employeeExample.createCriteria().andEmployeePositionNameEqualTo("电销员工");
			employees = 
					employeeMapper.selectByExample(employeeExample);
		}else {
			employees.add(employee);
		}
		return employees;
	}

}
