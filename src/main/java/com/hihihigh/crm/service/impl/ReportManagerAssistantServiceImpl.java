package com.hihihigh.crm.service.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hihihigh.crm.dao.CustomerMapper;
import com.hihihigh.crm.model.DataFormatForExcel;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.CustomerExample;
import com.hihihigh.crm.service.ReportManagerAssistantService;
import com.hihihigh.crm.tool.ExcelTool;

@Service
@Transactional
public class ReportManagerAssistantServiceImpl implements ReportManagerAssistantService{

	@Autowired
	DataSource dataSource;
	
	@Override
	@SuppressWarnings({ "rawtypes", "unused" })
	public String importInputStreamToDb(String dbName, InputStream is) {
		List<Map> list = ExcelTool.inputStreamToList(is);
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "insert into " + dbName + " ";
		// INSERT INTO table_name (列1, 列2,...) VALUES (值1,值2,...)
		List<String> columnslist = new ArrayList<String>();
		List<String> valueslist = new ArrayList<String>();
		// 提取表头
		if (list.size() >= 1) {
			Map map = list.get(0);
			Set keySet = map.keySet();
			for (Object keyName : keySet) {
				columnslist.add(keyName.toString());
				valueslist.add("?");
			}
		} else {
			return "1";
		}
		String columnsStr = columnslist.toString().substring(1,
				columnslist.toString().indexOf("]"));
		String valuesStr = valueslist.toString().substring(1,
				valueslist.toString().indexOf("]"));
		sql = sql + " (" + columnsStr + ") values (" + valuesStr + ")";
		// 写入数据库
		for (int i = 0; i < list.size(); i++) {
			Map map = list.get(i);
			try {
				conn = dataSource.getConnection();
				pstmt = conn.prepareStatement(sql);
				for (int j = 0; j < columnslist.size(); j++) {
					pstmt.setString(j + 1, map.get(columnslist.get(j))
							.toString());
				}
				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "0";
	}

	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public DataFormatForExcel exportCustomerData() {
		List<Customer> customers = 
				customerMapper.selectByExample(new CustomerExample());
		DataFormatForExcel dffe = new DataFormatForExcel();
		dffe.setTitle(Customer.getAllFields());
		ArrayList<ArrayList<String>> dataValues = new ArrayList<>();
		for (Customer customer : customers) {
			dataValues.add(customer.getAllFieldValuesByString());
		}
		dffe.setDatas(dataValues);
		return dffe;
	}

}
