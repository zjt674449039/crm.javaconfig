package com.hihihigh.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.service.CountDataCounselorService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/departmentManager")
public class DepartmentManagerController {
	@Autowired
	CountDataCounselorService countDataCounselorService;
	
	@RequestMapping
	public void manage(String accountName,HttpServletResponse response){
		List<Employee> employees = 
				countDataCounselorService.selectEmployeeIdsByAccountName(accountName);
		Helper.backByJson(response, employees);
	}

}
