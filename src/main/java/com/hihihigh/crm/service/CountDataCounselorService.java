package com.hihihigh.crm.service;

import java.util.List;

import com.hihihigh.crm.model.CountData;
import com.hihihigh.crm.model.autogenerator.Employee;

public interface CountDataCounselorService {

	/**
	 * 根据登陆账号的用户名,查询其负责的客户信息
	 * @param username 用户名
	 * @return 统计数据(咨询)
	 */
	List<CountData> countDataCounselor(String accountName);

	List<Employee> selectEmployeeIdsByAccountName(String accountName);

}
