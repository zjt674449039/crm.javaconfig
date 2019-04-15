package com.hihihigh.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/workspace")
public class WorkspaceController {
	@RequestMapping
	public String workspace(){
		return "workspace";
	}
}