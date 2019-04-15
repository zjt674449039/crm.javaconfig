package com.hihihigh.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.model.CountData;
import com.hihihigh.crm.service.CountDataCounselorService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/countDataCounselor")
public class CountDataCounselorController {
	@Autowired
	CountDataCounselorService countDataCounselorService;
	
	@RequestMapping
	public void countDataCounselor(String accountName,HttpServletResponse response){
		List<CountData> countDataCounselor = 
				countDataCounselorService.countDataCounselor(accountName);
		Helper.backByJson(response, countDataCounselor);
	}
}
