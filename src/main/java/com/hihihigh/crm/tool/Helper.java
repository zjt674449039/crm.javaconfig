package com.hihihigh.crm.tool;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class Helper {
	public static void backByJson(HttpServletResponse response, Object result) {
		String objectJson = JSON.toJSONString(result);
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(objectJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void backByJsonWithDateFormat(HttpServletResponse response, Object result,String dateFormat) {
		String objectJson = JSON.toJSONStringWithDateFormat(result, dateFormat);
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(objectJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void backByString(HttpServletResponse response, String result) {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void backResult(HttpServletResponse response,Integer result){
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String encodeFromIsoToUtf8(String oldString){
		String newString = "";
		try {
			newString = new String(oldString.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return newString;
	}
	
	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) { // 判断是不是GB2312
				String s = encode;
				return s; // 是的话，返回“GB2312“，以下代码同理
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) { // 判断是不是ISO-8859-1
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if(str.equals(new String(str.getBytes(encode), encode))) { // 判断是不是UTF-8

				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) { // 判断是不是GBK
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		return ""; // 如果都不是，说明输入的内容不属于常见的编码格式。
	}
	
	public static void printEncode(String object){
		System.out.println(getEncoding(object));
	}
	
	public static List<Integer> encodeJsonString(String jsonString){
		String tempString = jsonString.substring(1,jsonString.indexOf("]"));
		String[] tempStringArray = tempString.split(",");
		List<Integer> integers = new ArrayList<>();
		for(int i=0;i<tempStringArray.length;i++){
			integers.add(Integer.parseInt(tempStringArray[i]));
		}
		return integers;
	}
}
