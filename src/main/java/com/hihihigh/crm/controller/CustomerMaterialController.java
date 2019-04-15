package com.hihihigh.crm.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.service.CustomerMaterialService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/customerMaterial")
public class CustomerMaterialController {
	@Autowired
	CustomerMaterialService customerMaterialServiece;
	
	@RequestMapping("/addCustomerInfo")
	public void addCustomerInfo(
			String customerName,String educationalLevel,
			String customerTelephone,Integer qq,String customerEmail,
			Integer custmerStatusCustomerId,String customerRemark,
			HttpServletResponse response){
		Customer customer = new Customer(customerName,educationalLevel,
				customerTelephone,qq,customerEmail,custmerStatusCustomerId,customerRemark);
		String result = customerMaterialServiece.addCustomerInfo(customer);
		Helper.backByString(response, result);
	}
	
	@RequestMapping("/alterCustomerInfo")
	public void alterCustomerInfo(String customerJson,
			HttpServletResponse response){
		JSONObject jsonObject = JSONObject.parseObject(customerJson);
		Customer customer = jsonObject.toJavaObject(Customer.class);
		String result = customerMaterialServiece.alterCustomerInfo(customer);
		Helper.backByString(response, result);
	}
	
	@RequestMapping("/allotmentCustomerToTmk")
	public void allotmentCustomer(Integer customerId,Integer employeeId,
			HttpServletResponse response){
		String result = customerMaterialServiece.
				allotmentCustomerCustomer(customerId,employeeId);
		Helper.backByJson(response, result);
	}
	
	@RequestMapping("/allotmentCustomerToCounselor")
	public void allotmentCustomerToCounselor(Integer customerId,Integer employeeId,
			HttpServletResponse response){
		String result = customerMaterialServiece.
				allotmentCustomerToCounselor(customerId,employeeId);
		Helper.backByJson(response, result);
	}
}
