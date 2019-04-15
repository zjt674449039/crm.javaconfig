package com.hihihigh.crm.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.hihihigh.crm.model.DataFormatForExcel;
import com.hihihigh.crm.service.ReportManagerAssistantService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/reportManagerAssistant")
public class ReportManagerAssistantController {
	@Autowired
	ReportManagerAssistantService reportManagerAssistantService;
	
	@SuppressWarnings("finally")
	@RequestMapping("/importCustomerInfo")
	public String importCustomerInfo(
			@RequestPart("tableData") MultipartFile tableData,
			HttpServletResponse response){
		String result = "1";
		try {
			InputStream is = tableData.getInputStream();
			result = reportManagerAssistantService.importInputStreamToDb("customer", is);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (result.equals("0")) {
				return "../../../easyUi/successPage";
			}else {
				return "../../../easyUi/failedPage";
			}
		}
	}
	
	@RequestMapping("/exportCustomerInfo")
	public void exportExcelData(HttpServletResponse response){
		DataFormatForExcel dffe = 
				reportManagerAssistantService.exportCustomerData();
		Helper.backByJson(response, dffe);
	}
}
