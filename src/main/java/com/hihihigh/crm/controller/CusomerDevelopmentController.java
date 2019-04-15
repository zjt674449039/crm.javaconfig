package com.hihihigh.crm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.model.autogenerator.CustomerDevelopment;
import com.hihihigh.crm.service.CusomerDevelopmentService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/cusomerDevelopment")
public class CusomerDevelopmentController {
	@Autowired
	CusomerDevelopmentService cusomerDevelopmentService;
	
	@RequestMapping("/selectAllCustomerDevelopment")
	public void selectAllCustomerDevelopment(HttpServletResponse response){
		CustomerDevelopment[] customerDevelopments = 
				cusomerDevelopmentService.selectAllCustomerDevelopment();
		Helper.backByJson(response, customerDevelopments);
	}
	
	@RequestMapping("/alterCustomerDevelopment")
	public void alterCustomerDevelopment(CustomerDevelopment customerDevelopment,HttpServletResponse response){
		int result = cusomerDevelopmentService.alterCustomerDevelopment(customerDevelopment);
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
