package com.hihihigh.crm.controller;

/*import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.hihihigh.crm.dao.CustomerMapper;
import com.hihihigh.crm.model.DataFormatForExcel;
import com.hihihigh.crm.model.TestModel;
import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.service.AccountManagerSuperService;
import com.hihihigh.crm.service.TestService;
import com.hihihigh.crm.service.impl.ExcelHandlerServiceImpl;
import com.hihihigh.crm.tool.Helper;*/

@Controller
@RequestMapping({"/","/home"})
public class HomeController {
	/*@Autowired
	public TestService testService;*/
	
	@RequestMapping
	public String home(){
		return "redirect:easyUi/workspace.jsp";
	}
	
	/*@RequestMapping(path="/test",method=RequestMethod.GET)
	public String databaseTest(Long id,Model model){
		TestModel resultModel = testService.serviceMethod(id);
		if (resultModel!=null) {
			//默认key=testModel,即数据的类型,首字母小写
			model.addAttribute(resultModel);
		}
		return "test";
	}
	
	@RequestMapping("addPosition")
	public String authorityManager(){
		return "authorityManager/addPosition";
	}
	
	@RequestMapping("alterAuthority")
	public String alterAuthority(){
		return "authorityManager/alterAuthority";
	}
	
	@RequestMapping("deleteAuthority")
	public String deleteAuthority(){
		return "authorityManager/deleteAuthority";
	}
	
	@Autowired
	AccountManagerSuperService accountManagerSuperService;
	
	@RequestMapping("addAdmin")
	public String addAdmin(Model model){
		model.addAttribute(new Account());
		//account的accountEmployeeId需要从员工表中查询,
		//查询条件:employeePositionName等于`管理员`
		//将查出来的结果list放在model里,键名为accountEmployeeIds
		return "accountManagerSuper/addAdmin";
	}
	
	@RequestMapping("deleteAdmin")
	public String deleteAdmin(Model model){
		List<Account> accounts = accountManagerSuperService.
				selectAdminAccounts();
		model.addAttribute("accounts",accounts);
		return "accountManagerSuper/deleteAdmin";
	}
	
	@RequestMapping("selectAllAccounts")
	public String selectAllAccounts(){
		return "accountManagerSuper/selectAllAccounts";
	}
	
	@RequestMapping("selectEmployeeByCondition")
	public String selectEmployeeByCondition(){
		return "reportManagerSuper/selectEmployeeByCondition";
	}
	
	@RequestMapping("selectCustomerByCondition")
	public String selectCustomerByCondition(){
		return "reportManagerSuper/selectCustomerByCondition";
	}
	
	@RequestMapping("addTypicalAccount")
	public String addTypicalAccount(Model model){
		model.addAttribute(new Account());
		return "accountManagerAdmin/addTypicalAccount";
	}
	
	@RequestMapping("deleteTypicalAccount")
	public String deleteTypicalAccount(Model model){
		model.addAttribute(new Account());
		return "accountManagerAdmin/deleteTypicalAccount";
	}
	
	@RequestMapping("resetAccountPassword")
	public String resetAccountPassword(Model model){
		model.addAttribute(new Account());
		return "accountManagerAdmin/resetAccountPassword";
	}
	
	@RequestMapping("selectAllSalesEmployees")
	public String selectAllSalesEmployees(Model model){
		model.addAttribute(new Account());
		return "accountManagerAssistant/selectAllSalesEmployees";
	}
	
	@Autowired
	CustomerMapper customerMapper;
	
	@RequestMapping("test")
	public void test() {
		Customer customer = new Customer();
		customer.setCreateTime(new Date());
		customer.setCustmerStatusCustomerId(1);
		customer.setCustomerName("测试4");
		customer.setCustomerTelephone("12242222222");
		customerMapper.insertSelective(customer);
		System.out.println(customer.getId());
	}
	
	@Autowired
	ExcelHandlerServiceImpl excelHandlerServiceImpl;
	
	@RequestMapping("/easyUi/excelDataTransfer")
	@ResponseBody
	public void excelTest(
			@RequestPart("tableData") MultipartFile tableData,
			HttpServletResponse response){
		try {
			InputStream is = tableData.getInputStream();
			String result = excelHandlerServiceImpl.importInputStreamToDb("account", is);
			Helper.backByString(response, result);
		} catch (IOException e) {
			e.printStackTrace();
			Helper.backByString(response, "1");
		}
	}
	
	@RequestMapping("/easyUi/exportExcelData")
	public void exportExcelData(HttpServletResponse response){
		List<Account> accounts = 
				accountManagerSuperService.selectAllAccounts();
		DataFormatForExcel dffe = new DataFormatForExcel();
		dffe.setTitle(Account.getAllFields());
		ArrayList<ArrayList<String>> dataValues = new ArrayList<>();
		for (Account account : accounts) {
			dataValues.add(account.getAllFieldValuesByString());
		}
		dffe.setDatas(dataValues);
		Helper.backByJson(response, dffe);
	}*/
	
}
