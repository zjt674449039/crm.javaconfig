package com.hihihigh.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hihihigh.crm.model.autogenerator.NameAuthority;
import com.hihihigh.crm.service.impl.MyUserDetailsServiceImp;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping
	public String login(){
		return "login";
	}
	
	@Autowired
	MyUserDetailsServiceImp myUserDetailsServiceImp;
	
	@RequestMapping("/selectUserInfo")
	public void selectUserInfo(String username,HttpServletResponse response){
		List<NameAuthority> nameAuthorities = myUserDetailsServiceImp.selectNameAccountsByUsername(username);
		Helper.backByJson(response, nameAuthorities);
	}
}
