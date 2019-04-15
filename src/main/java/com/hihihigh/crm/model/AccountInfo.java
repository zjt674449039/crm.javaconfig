package com.hihihigh.crm.model;

import com.hihihigh.crm.model.autogenerator.Account;
import com.hihihigh.crm.model.autogenerator.Employee;

public class AccountInfo {

	@Override
	public String toString() {
		return "AccountInfo [accountId=" + accountId + ", username=" + username + ", password=" + password
				+ ", nickName=" + nickName + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", employeePositionName=" + employeePositionName + ", employeeCellphone=" + employeeCellphone
				+ ", employeeTelephone=" + employeeTelephone + ", employeeStatus=" + employeeStatus + "]";
	}

	private Integer accountId;
	private String username;
	private String password;
	private String nickName;
	private Integer employeeId;
	private String employeeName;
	private String employeePositionName;
	private String employeeCellphone;
	private String employeeTelephone;
	private Integer employeeStatus;

	public AccountInfo(Account account, Employee employee) {
		accountId = account.getId();
		username = account.getUsername();
		password = account.getPassword();
		nickName = account.getNickName();
		employeeId = employee.getId();
		employeeName = employee.getEmployeeName();
		employeePositionName = employee.getEmployeePositionName();
		employeeCellphone = employee.getEmployeeCellphone();
		employeeTelephone = employee.getEmployeeTelephone();
		employeeStatus = employee.getEmployeeStatus();
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePositionName() {
		return employeePositionName;
	}

	public void setEmployeePositionName(String employeePositionName) {
		this.employeePositionName = employeePositionName;
	}

	public String getEmployeeCellphone() {
		return employeeCellphone;
	}

	public void setEmployeeCellphone(String employeeCellphone) {
		this.employeeCellphone = employeeCellphone;
	}

	public String getEmployeeTelephone() {
		return employeeTelephone;
	}

	public void setEmployeeTelephone(String employeeTelephone) {
		this.employeeTelephone = employeeTelephone;
	}

	public Integer getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(Integer employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public AccountInfo() {
		super();
	}
}
