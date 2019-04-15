package com.hihihigh.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.model.CountData;
import com.hihihigh.crm.service.CountDataDevelopmentService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/countDataDevelopment")
public class CountDataDevelopmentController {
	@Autowired
	CountDataDevelopmentService countDataDevelopmentService;
	
	@RequestMapping
	public void countDataDevelopment(String accountName,HttpServletResponse response){
		List<CountData> countDataDevelopment = 
				countDataDevelopmentService.countDataDevelopment(accountName);
		Helper.backByJson(response, countDataDevelopment);
	}
}
