package com.hihihigh.crm.service;

import java.io.InputStream;

import com.hihihigh.crm.model.DataFormatForExcel;

public interface ReportManagerAssistantService {

	String importInputStreamToDb(String string, InputStream is);

	DataFormatForExcel exportCustomerData();

}
