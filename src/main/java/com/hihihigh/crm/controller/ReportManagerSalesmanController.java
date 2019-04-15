package com.hihihigh.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.service.ReportManagerSalesmanService;

@Controller
@RequestMapping("/workspace/reportManagerSalesman")
public class ReportManagerSalesmanController {
	@Autowired
	ReportManagerSalesmanService reportManagerSalesmanService;
	
	@RequestMapping
	public void reportManagerSalesman(){
		//导出客户开发报表
	}
}
