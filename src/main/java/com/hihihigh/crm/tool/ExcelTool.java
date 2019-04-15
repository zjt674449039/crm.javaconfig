package com.hihihigh.crm.tool;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelTool {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Map> rsToList(ResultSet rs) throws java.sql.SQLException {
		if (rs == null)
			return Collections.EMPTY_LIST;
		ResultSetMetaData md = rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
		int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数
		List<Map> list = new ArrayList();
		Map rowData = new LinkedHashMap();
		while (rs.next()) {
			rowData = new LinkedHashMap(columnCount);
			for (int i = 1; i <= columnCount; i++) {
				rowData.put(md.getColumnName(i), rs.getObject(i));
			}
			list.add(rowData);
		}
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Map> inputStreamToList(InputStream is) {
		Workbook book = null;
		List<Map> list = null;
		try {
			book = Workbook.getWorkbook(is);// 创建一个新的写入工作簿
			Sheet sheet = book.getSheet(0);
			int totalRows = sheet.getRows();
			int totalColumns = sheet.getColumns();
			Cell[] cell = sheet.getRow(0);
			if (totalColumns <= 0) {
				return null;
			}
			// 读取第一行作为Map中的key
			List tableHeaderlist = new ArrayList();
			for (int i = 0; i < totalColumns; i++) {
				tableHeaderlist.add(cell[i].getContents());
			}
			// 将每一行存为Map集合，然后存为list
			list = new ArrayList();
			Map rowData = new LinkedHashMap();
			for (int i = 1; i < totalRows; i++) {
				cell = sheet.getRow(i);
				rowData = new LinkedHashMap(totalColumns);
				for (int j = 0; j < totalColumns; j++) {
					rowData.put(tableHeaderlist.get(j), cell[j].getContents());
				}
				list.add(rowData);
			}
			book.close();// 关闭
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
