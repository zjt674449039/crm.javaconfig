package com.hihihigh.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.TestDao;
import com.hihihigh.crm.model.TestModel;
import com.hihihigh.crm.service.TestService;

@Service
@Transactional
public class TestServiceImp implements TestService{

	@Autowired
	TestDao testDao;
	
	@Override
	public TestModel serviceMethod(Long id) {
		return testDao.testDao(id);
	}

}
