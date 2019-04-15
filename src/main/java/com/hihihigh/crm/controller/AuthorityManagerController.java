package com.hihihigh.crm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hihihigh.crm.model.autogenerator.Position;
import com.hihihigh.crm.service.AuthorityManagerService;
import com.hihihigh.crm.tool.Helper;

@Controller
@RequestMapping("/workspace/authorityManager")
public class AuthorityManagerController {
	@Autowired
	AuthorityManagerService authorityManagerService;
	
	@RequestMapping(path = "/addPosition")
	public void addAuthority(String positionName,
			Integer positionDepartmentId,
			Integer[] authorityNameAuthorityIds,
			HttpServletResponse response) {
		for (Integer integer : authorityNameAuthorityIds) {
			System.out.println(integer);
		}
		String result = authorityManagerService.addPosition(
				new Position(positionName, positionDepartmentId),
				authorityNameAuthorityIds);
		Helper.backByJson(response, result);
	}

	@RequestMapping("/alterAuthority")
	public void alterAuthority(Integer positionId,
			Integer[] authorityIds,
			HttpServletResponse response) {
		List<Integer> authorityIds0 = new ArrayList<>();
		for (Integer integer : authorityIds) {
			authorityIds0.add(integer);
		}
		String result = authorityManagerService.alterAuthority(
				positionId, authorityIds0);
		Helper.backByJson(response, result);
	}

	@RequestMapping("/deleteAuthority")
	public void deleteAuthority(Integer positionId,
			@RequestParam Integer[] authorityIds,
			HttpServletResponse response) {
		List<Integer> authorityIds0 = new ArrayList<>();
		for (Integer integer : authorityIds) {
			authorityIds0.add(integer);
		}
		String result = authorityManagerService.deleteAuthority(
				positionId, authorityIds0);
		Helper.backByJson(response, result);
	}

}
