package com.hihihigh.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.service.AccountManagerAdminService;
import com.hihihigh.crm.service.AccountManagerSuperService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/accountManagerAdmin")
public class AccountManagerAdminController {
	@Autowired
	AccountManagerAdminService accountManagerAdminService;
	
	@Autowired
	AccountManagerSuperService accountManagerSuperService;
	
	@RequestMapping("/addTypicalAccount")
	public void addTypicalAccount(String username,String password,
			String nickName,String employeeName,String employeePositionName,
			String employeeCellphone,String employeeTelephone,
			HttpServletResponse response){
		Account account = new Account(username,password,nickName);
		Employee employee = new Employee(employeeName,employeePositionName,employeeCellphone,employeeTelephone);
		String result = accountManagerSuperService.addAcccount(employee,account);
		Helper.backByString(response, result);
	}
	
	@RequestMapping("/deleteTypicalAccount")
	public void deleteTypicalAccount(
			String accountIds,String employeeIds,
			HttpServletResponse response){
		List<Integer> accountIds0 = Helper.encodeJsonString(accountIds);
		List<Integer> employeeIds0 = Helper.encodeJsonString(employeeIds);
		String result = accountManagerAdminService.deleteTypicalAccount(accountIds0,employeeIds0);
		Helper.backByString(response, result);
	}
	
	@RequestMapping("/resetAccountPassword")
	@ResponseBody
	public void resetAccountPassword(int accountId,HttpServletResponse response){
		String result = accountManagerAdminService.resetAccountPassword(accountId);
		Helper.backByString(response, result);;
	}
}
