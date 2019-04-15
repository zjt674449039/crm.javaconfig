package com.hihihigh.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.service.AccountManagerSuperService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/accountManagerSuper")
public class AccountManagerSuperController {
	
	@Autowired
	AccountManagerSuperService accountManagerSuperService;
	
	
	@RequestMapping("/addAdmin")
	public void addAdmin(String username,String password,
			String nickName,String employeeName,
			String employeeCellphone,String employeeTelephone,
			HttpServletResponse response){
		Account account = new Account(username,password,nickName);
		Employee employee = new Employee(employeeName,"管理员",employeeCellphone,employeeTelephone);
		String result = accountManagerSuperService.addAcccount(employee,account);
		Helper.backByString(response, result);
	}
	
	@RequestMapping("/deleteAccount")
	public void deleteAdmin(
			String accountIds,String employeeIds,
			HttpServletResponse response){
		List<Integer> accountIds0 = Helper.encodeJsonString(accountIds);
		List<Integer> employeeIds0 = Helper.encodeJsonString(employeeIds);
		String result = accountManagerSuperService.deleteAdmin(accountIds0,employeeIds0);
		Helper.backByString(response, result);
	}
	
	@RequestMapping("/selectAllAccounts")
	public void selectAllAccounts(HttpServletResponse response){
		List<Account> accounts= accountManagerSuperService.selectAllAccounts();
		Helper.backByJson(response, accounts);
	}
}
