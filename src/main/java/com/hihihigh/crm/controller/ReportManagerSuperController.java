package com.hihihigh.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.service.ReportManagerSuperService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/reportManagerSuper")
public class ReportManagerSuperController {
	@Autowired
	ReportManagerSuperService reportManagerSuperService;
	
	@RequestMapping("/selectEmployeeByCondition")
	public void selectEmployeeByCondition(String condition,
			HttpServletResponse response){
		String condition0 = Helper.encodeFromIsoToUtf8(condition);
		List<Employee> employees = reportManagerSuperService.
				selectEmployeeByCondition(condition0);
		Helper.backByJson(response, employees);
	}
	
	@RequestMapping("/selectCustomerByCondition")
	public void selectCustomerByCondition(String condition,
			HttpServletResponse response){
		String condition0 = Helper.encodeFromIsoToUtf8(condition);
		List<Customer> customers = reportManagerSuperService.
				selectCustomersByCondition(condition0);
		Helper.backByJsonWithDateFormat(response, customers, "yyyy-MM-dd");
	}
}
