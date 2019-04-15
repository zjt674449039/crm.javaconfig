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
import com.hihihigh.crm.model.autogenerator.CustomerDevelopment;
import com.hihihigh.crm.service.CustomerAdviceService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/customerAdvice")
public class CustomerAdviceController {
	@Autowired
	CustomerAdviceService customerAdviceService;
	
	@RequestMapping("/selectVisitingCustomers")
	public void selectVisitingCustomers(HttpServletResponse response){
		List<Customer> customers = customerAdviceService.selectVisitingCustomers();
		Helper.backByJson(response, customers);
	}
	
	@RequestMapping("/alterCustomer")
	public void alterCustomer(int customerId,String remark,HttpServletResponse response){
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setCustomerRemark(remark);
		String result = customerAdviceService.alterRemark(customer);
		Helper.backByString(response, result);
	}
	
	@RequestMapping("/addCustomerDevelopment")
	public void addCustomerDevelopment(Integer customerId,String accountName,HttpServletResponse response){
		String result = customerAdviceService.addCustomerDevelopment(customerId,accountName);
		Helper.backByString(response, result);
	}
	
	@RequestMapping("/selectCustomerFollowingInfo")
	public void selectCustomerFollowingInfo(String accountName,
			HttpServletResponse response){
		List<CustomerFollowInfo> customerFollowInfos= customerAdviceService
				.selectCustomerFollowingInfo(accountName);
		Helper.backByJsonWithDateFormat(response, customerFollowInfos,
				"yyyy-MM-dd' 'HH:mm:ss");
	}
	
	@RequestMapping("/alterCustomerFollowInfo")
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
		CustomerDevelopment customerDevelopment = 
				new CustomerDevelopment(cdId,date);
		String result = customerAdviceService.
				alterCustomerFollowInfo(customer,customerDevelopment);
		Helper.backByString(response, result);
	}
	
}
