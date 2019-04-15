package com.hihihigh.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.service.AccountManagerAssistantService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/accountManagerAssistant")
public class AccountManagerAssistantController {
	@Autowired
	AccountManagerAssistantService accountManagerAssistantService;
	
	@RequestMapping("/selectAllSalesEmployees")
	public void selectAllSalesEmployees(HttpServletResponse response){
		List<Employee> employees = accountManagerAssistantService.selectEmployeesByPositionName("电销员工");
		Helper.backByJson(response, employees);
	}
	
	@RequestMapping("/selectAllCounselorEmployees")
	public void selectAllCounselorEmployees(HttpServletResponse response){
		List<Employee> employees = accountManagerAssistantService.selectEmployeesByPositionName("咨询师");
		Helper.backByJson(response, employees);
	}
}
