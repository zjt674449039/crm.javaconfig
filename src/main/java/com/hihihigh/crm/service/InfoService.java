package com.hihihigh.crm.service;

import java.util.List;

import com.hihihigh.crm.model.AccountInfo;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.Department;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.model.autogenerator.NameAuthority;
import com.hihihigh.crm.model.autogenerator.Position;
import com.hihihigh.crm.model.autogenerator.StatusCustmer;

public interface InfoService {

	List<Department> selectAllDepartmentInfo();

	List<NameAuthority> selectAllNameAuthorityInfo();

	List<Position> selectAllPositionInfo();

	List<NameAuthority> selectAuthorityByPositionId(int positionId);

	List<AccountInfo> selectAccountAndEmployeeInfoByTypeAccount(String typeAccount);

	List<AccountInfo> selectAllAccountAndEmployeeInfo();

	List<AccountInfo> selectAccountAndEmployeeUnAdmin();

	List<Position> selectAllPositionInfoUnAdmin();

	List<StatusCustmer> selectAllStatusCustomers();

	List<StatusCustmer> selectcustomerStatusOnNewBuilt();

	List<Customer> selectcustomerInfo();

	List<Customer> selectCustomerForTmkInfo();

	List<Employee> selectTmkEmployee();

	List<Customer> selectCustomerForCounselorInfo();

	List<Employee> selectCounselorEmployee();

}
