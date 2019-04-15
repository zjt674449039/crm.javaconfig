package com.hihihigh.crm.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.model.DataFormatForExcel;
import com.hihihigh.crm.service.ReportManagerInternetCounselorService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/reportManagerInternetCounselor")
public class ReportManagerInternetCounselorController {
	@Autowired
	ReportManagerInternetCounselorService reportManagerInternetCounselorService;

	@RequestMapping
	public void reportManagerInternetCounselor(
			String accountName,HttpServletResponse response){
		DataFormatForExcel dffe = 
				reportManagerInternetCounselorService.exportCustomerDevelopmentData(accountName);
		Helper.backByJson(response, dffe);
	}
}
