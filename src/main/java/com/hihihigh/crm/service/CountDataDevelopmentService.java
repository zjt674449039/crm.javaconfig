package com.hihihigh.crm.service;

import java.util.List;

import com.hihihigh.crm.model.CountData;

public interface CountDataDevelopmentService {
	
	/**
	 * 根据用户名,查询对应员工负责的客户相关信息
	 * @param username 账号用户名
	 * @return 统计数据(开发)
	 */
	List<CountData> countDataDevelopment(String username);

}
