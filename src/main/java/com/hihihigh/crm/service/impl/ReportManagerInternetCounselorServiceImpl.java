package com.hihihigh.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.CustomerDevelopmentBeforeMapper;
import com.hihihigh.crm.model.DataFormatForExcel;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopmentBefore;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopmentBeforeExample;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.service.CountDataCounselorService;
import com.hihihigh.crm.service.ReportManagerInternetCounselorService;

@Service
@Transactional
public class ReportManagerInternetCounselorServiceImpl implements ReportManagerInternetCounselorService{
	@Autowired
	CustomerDevelopmentBeforeMapper customerDevelopmentBeforeMapper;
	
	@Autowired
	CountDataCounselorService countDataCounselorService;
	
	@Override
	public DataFormatForExcel exportCustomerDevelopmentData(String accountName) {
		List<Employee> employees = 
				countDataCounselorService.selectEmployeeIdsByAccountName(accountName);
		List<Integer> employeeIds = new ArrayList<>();
		for (Employee employee : employees) {
			employeeIds.add(employee.getId());
		}
		CustomerDevelopmentBeforeExample cdbe = new CustomerDevelopmentBeforeExample();
		cdbe.createCriteria().andCd0EmployeeIdIn(employeeIds);
		List<CustomerDevelopmentBefore> cdbs = 
				customerDevelopmentBeforeMapper.selectByExample(
						cdbe);
		DataFormatForExcel dffe = new DataFormatForExcel();
		dffe.setTitle(CustomerDevelopmentBefore.getAllFields());
		ArrayList<ArrayList<String>> dataValues = new ArrayList<>();
		for (CustomerDevelopmentBefore cdb : cdbs) {
			dataValues.add(cdb.getAllFieldValuesByString());
		}
		dffe.setDatas(dataValues);
		return dffe;
	}

}
