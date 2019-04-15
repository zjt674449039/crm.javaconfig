package com.hihihigh.crm.service;

import com.hihihigh.crm.model.autogenerator.CustomerDevelopment;

public interface CusomerDevelopmentService {

	/**
	 * 查看所有用户开发信息
	 * @return 用户开发信息(多)
	 */
	CustomerDevelopment[] selectAllCustomerDevelopment();

	/**
	 * 根据客户id,修改客户开发表中的相应信息
	 * @param customerDevelopment 期待修改成的客户开发信息
	 * @return 0 操作成功 1 操作失败
	 */
	int alterCustomerDevelopment(CustomerDevelopment customerDevelopment);

}
