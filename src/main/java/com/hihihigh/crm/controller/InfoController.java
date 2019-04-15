package com.hihihigh.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.model.AccountInfo;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.Department;
import com.hihihigh.crm.model.autogenerator.Employee;
import com.hihihigh.crm.model.autogenerator.NameAuthority;
import com.hihihigh.crm.model.autogenerator.Position;
import com.hihihigh.crm.model.autogenerator.StatusCustmer;
import com.hihihigh.crm.service.InfoService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	InfoService infoService;
	
	@RequestMapping("/departmentInfo")
	public void departmentInfo(HttpServletResponse response){
		List<Department> departments = infoService.selectAllDepartmentInfo();
		Helper.backByJson(response, departments);
	}
	
	@RequestMapping("/nameAuthorityInfo")
	public void nameAuthorityInfo(HttpServletResponse response){
		List<NameAuthority> nameAuthorities = infoService.selectAllNameAuthorityInfo();
		Helper.backByJson(response, nameAuthorities);
	}
	
	@RequestMapping("/nameAuthorityByPositionIdInfo")
	public void nameAuthorityByPositionIdInfo(
			int positionId,
			HttpServletResponse response){
		List<NameAuthority> nameAuthorities = infoService.selectAuthorityByPositionId(positionId);
		Helper.backByJson(response, nameAuthorities);
	}
	
	@RequestMapping("/positionInfo")
	public void positionInfo(HttpServletResponse response){
		List<Position> positions = infoService.selectAllPositionInfo();
		Helper.backByJson(response, positions);
	}
	
	@RequestMapping("/positionInfoUnAdmin")
	public void positionInfoUnAdmin(HttpServletResponse response){
		List<Position> positions = infoService.selectAllPositionInfoUnAdmin();
		Helper.backByJson(response, positions);
	}
	
	@RequestMapping("/accountAndEmployeeInfo")
	public void accountAndEmployeeInfo(String type,
			HttpServletResponse response){
		String typeAccount = Helper.encodeFromIsoToUtf8(type);
		List<AccountInfo> accountInfos = infoService.selectAccountAndEmployeeInfoByTypeAccount(typeAccount);
		Helper.backByJson(response, accountInfos);
	}
	
	@RequestMapping("/allAccountAndEmployeeInfo")
	public void allAccountAndEmployeeInfo(
			HttpServletResponse response){
		List<AccountInfo> accountInfos = infoService.selectAllAccountAndEmployeeInfo();
		Helper.backByJson(response, accountInfos);
	}
	
	@RequestMapping("/accountAndEmployeeInfoUnAdmin")
	public void accountAndEmployeeInfoUnAdmin(
			HttpServletResponse response){
		List<AccountInfo> accountInfos = infoService.selectAccountAndEmployeeUnAdmin();
		Helper.backByJson(response, accountInfos);
	}
	
	@RequestMapping("/statusCustomer")
	public void statusCustomer(
			HttpServletResponse response){
		List<StatusCustmer> statusCustmers = infoService.selectAllStatusCustomers();
		Helper.backByJson(response, statusCustmers);
	}
	
	@RequestMapping("/customerStatusOnNewBuilt")
	public void customerStatusOnNewBuilt(
			HttpServletResponse response){
		List<StatusCustmer> statusCustmers = infoService.selectcustomerStatusOnNewBuilt();
		Helper.backByJson(response, statusCustmers);
	}
	
	@RequestMapping("/customerInfo")
	public void customerInfo(
			HttpServletResponse response){
		List<Customer> statusCustmers = infoService.selectcustomerInfo();
		Helper.backByJsonWithDateFormat(response, statusCustmers, "yyyy-MM-dd");
	}
	
	@RequestMapping("/customerForTmkInfo")
	public void customerForTmkInfo(
			HttpServletResponse response){
		List<Customer> statusCustmers = infoService.selectCustomerForTmkInfo();
		Helper.backByJsonWithDateFormat(response, statusCustmers, "yyyy-MM-dd");
	}
	
	@RequestMapping("/tmkEmployee")
	public void tmkEmployee(
			HttpServletResponse response){
		List<Employee> employees = infoService.selectTmkEmployee();
		Helper.backByJson(response, employees);
	}
	
	@RequestMapping("/customerForCounselorInfo")
	public void customerForCounselorInfo(
			HttpServletResponse response){
		List<Customer> statusCustmers = infoService.selectCustomerForCounselorInfo();
		Helper.backByJsonWithDateFormat(response, statusCustmers, "yyyy-MM-dd");
	}
	
	@RequestMapping("/counselorEmployee")
	public void counselorEmployee(
			HttpServletResponse response){
		List<Employee> employees = infoService.selectCounselorEmployee();
		Helper.backByJson(response, employees);
	}
}
