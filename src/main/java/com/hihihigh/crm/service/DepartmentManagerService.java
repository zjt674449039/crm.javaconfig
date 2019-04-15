package com.hihihigh.crm.service;

import java.util.List;

import com.hihihigh.crm.model.autogenerator.Employee;

public interface DepartmentManagerService {
	/**
	 * 查看该部门的所有普通员工
	 * @param username 主管账号姓名
	 * @return 该部门的所有普通员工(多)
	 */
	List<Employee> manage(String username);

}
