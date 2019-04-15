package com.hihihigh.crm.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataFormatForExcel {
	private ArrayList<Map<String, String>> title = new ArrayList<>();
	private ArrayList<ArrayList<Map<String, String>>> datas = new ArrayList<>();

	public void setTitle(ArrayList<String> titleValues){
		Map<String, String> map;
		for (String titleValue : titleValues) {
			map = new LinkedHashMap<String,String>();
			map.put("value", titleValue);
			map.put("type", "ROW_HEADER_HEADER");
			map.put("datatype", "string");
			title.add(map);
		}
	}
	
	public void setDatas(ArrayList<ArrayList<String>> datasValues){
		ArrayList<Map<String, String>> row;
		Map<String, String> map1;
		for (ArrayList<String> dataValues : datasValues) {
			row = new ArrayList<>();
			for (String dataValue : dataValues) {
				map1 = new LinkedHashMap<String,String>();
				map1.put("value", dataValue);
				map1.put("type", "ROW_HEADER_HEADER");
				row.add(map1);
			}
			datas.add(row);
		}
	}

	public ArrayList<Map<String, String>> getTitle() {
		return title;
	}

	public ArrayList<ArrayList<Map<String, String>>> getDatas() {
		return datas;
	}

}
