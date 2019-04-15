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

import com.hihihigh.crm.tool.ExcelTool;

@Service
@Transactional
public class ExcelHandlerServiceImpl {
	
	@Autowired
	DataSource dataSource;

	@SuppressWarnings({ "rawtypes" })
	public List<Map> exportDbToList(String dbName) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Map> tableContent = null;
		String sql = "select * from " + dbName;
		try {
			conn = dataSource.getConnection();;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			/*System.out.println(JSON.toJSONString(rs));*/
			tableContent = ExcelTool.rsToList(rs);
			pstmt.close();
			rs.close();
			conn.close();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return tableContent;
	}

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
}
