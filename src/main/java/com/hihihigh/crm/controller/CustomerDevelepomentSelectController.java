package com.hihihigh.crm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.model.CustomerFollowInfo;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopmentBefore;
import com.hihihigh.crm.service.CustomerDevelepomentSelectService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/customerDevelepomentSelect")
public class CustomerDevelepomentSelectController {
	@Autowired
	CustomerDevelepomentSelectService customerDevelepomentSelectService;
	
	@RequestMapping("/addCustomerInfoByAccountName")
	public void addCustomerInfoByAccountName(
			String customerName,String educationalLevel,
			String customerTelephone,Integer qq,String customerEmail,
			Integer custmerStatusCustomerId,String customerRemark,
			String accountName,
			HttpServletResponse response){
		Customer customer = new Customer(customerName,educationalLevel,
				customerTelephone,qq,customerEmail,custmerStatusCustomerId,customerRemark);
		String result = customerDevelepomentSelectService.addCustomerInfo(customer,accountName);
		Helper.backByString(response, result);
	}
	
	@RequestMapping("/selectCustomerFollowingInfo")
	public void selectCustomerFollowingInfo(String accountName,
			HttpServletResponse response){
		List<CustomerFollowInfo> customerFollowInfos= customerDevelepomentSelectService
				.selectCustomerFollowingInfo(accountName);
		Helper.backByJsonWithDateFormat(response, customerFollowInfos,
				"yyyy-MM-dd' 'HH:mm:ss");
	}
	
	@RequestMapping("/alterCustomerFollowInfo")
	public void alterCustomerFollowInfo(
			int customerId,String customerName,Integer custmerStatusCustomerId,
			String customerRemark,String nextContactTime,Integer cdId,
			HttpServletResponse response) throws ParseException{
		if (customerRemark==null||customerRemark.equals("")) {
			customerRemark = null;
		}
		Date date = null;
		if (nextContactTime!=null&&!nextContactTime.equals("")) {
			date = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss").parse(nextContactTime);
		}
		Customer customer = 
				new Customer(customerId,custmerStatusCustomerId,customerRemark);
		CustomerDevelopmentBefore customerDevelopmentBefore = 
				new CustomerDevelopmentBefore(cdId,date);
		String result = customerDevelepomentSelectService.
				alterCustomerFollowInfo(customer,customerDevelopmentBefore);
		Helper.backByString(response, result);
	}
	
	/*@RequestMapping("/alterCustomerFollowInfo")
	public void alterCustomerFollowInfo(
			int customerId,Integer custmerStatusCustomerId,String customerRemark,
			int cdId,String nextContactTime,
			HttpServletResponse response) throws ParseException{
		if (customerRemark==null||customerRemark.equals("")) {
			customerRemark = null;
		}
		Date date = null;
		if (nextContactTime!=null&&!nextContactTime.equals("")) {
			date = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss").parse(nextContactTime);
		}
		Customer customer = 
				new Customer(customerId,custmerStatusCustomerId,customerRemark);
		CustomerDevelopmentBefore customerDevelopmentBefore = 
				new CustomerDevelopmentBefore(cdId,date);
		String result = customerDevelepomentSelectService.
				alterCustomerFollowInfo(customer,customerDevelopmentBefore);
		Helper.backByString(response, result);
	}*/
}
