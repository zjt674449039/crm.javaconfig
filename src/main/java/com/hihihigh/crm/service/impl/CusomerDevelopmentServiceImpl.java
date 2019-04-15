package com.hihihigh.crm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.model.autogenerator.CustomerDevelopment;
import com.hihihigh.crm.service.CusomerDevelopmentService;

@Service
@Transactional
public class CusomerDevelopmentServiceImpl implements CusomerDevelopmentService{

	@Override
	public CustomerDevelopment[] selectAllCustomerDevelopment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int alterCustomerDevelopment(CustomerDevelopment customerDevelopment) {
		// TODO Auto-generated method stub
		return 0;
	}

}
