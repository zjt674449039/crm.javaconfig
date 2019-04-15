package com.hihihigh.crm.model;

import java.util.Date;

import com.hihihigh.crm.model.autogenerator.Customer;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopment;
import com.hihihigh.crm.model.autogenerator.CustomerDevelopmentBefore;

public class CustomerFollowInfo {
	private Integer customerId;
	private String customerName;
	private String customerTelephone;
	private Integer custmerStatusCustomerId;
	private String customerRemark;
	private Integer cdId;
	private Date allocationTime;// 当作咨询时间
	private Date nextContactTime;
	private Integer employeeId;

	public CustomerFollowInfo(Customer customer, CustomerDevelopment customerDevelopment) {
		customerId = customer.getId();
		customerName = customer.getCustomerName();
		customerTelephone = customer.getCustomerTelephone();
		custmerStatusCustomerId = customer.getCustmerStatusCustomerId();
		customerRemark = customer.getCustomerRemark();
		cdId = customerDevelopment.getId();
		allocationTime = customerDevelopment.getAllocationTime();
		nextContactTime = customerDevelopment.getNextContactTime();
		employeeId = customerDevelopment.getCdEmployeeId();
	}

	public CustomerFollowInfo(Customer customer, CustomerDevelopmentBefore customerDevelopmentBefore) {
		customerId = customer.getId();
		customerName = customer.getCustomerName();
		customerTelephone = customer.getCustomerTelephone();
		custmerStatusCustomerId = customer.getCustmerStatusCustomerId();
		customerRemark = customer.getCustomerRemark();
		cdId = customerDevelopmentBefore.getId();
		allocationTime = customerDevelopmentBefore.getCd0AllocationTime();
		nextContactTime = customerDevelopmentBefore.getNextContactTime();
		employeeId = customerDevelopmentBefore.getCd0EmployeeId();
	}
	
	public CustomerFollowInfo() {
		super();
	}

	@Override
	public String toString() {
		return "CustomerFollowInfo [customerId=" + customerId + ", customerName=" + customerName
				+ ", customerTelephone=" + customerTelephone + ", custmerStatusCustomerId=" + custmerStatusCustomerId
				+ ", customerRemark=" + customerRemark + ", cdId=" + cdId + ", allocationTime=" + allocationTime
				+ ", nextContactTime=" + nextContactTime + ", employeeId=" + employeeId + "]";
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerTelephone() {
		return customerTelephone;
	}

	public void setCustomerTelephone(String customerTelephone) {
		this.customerTelephone = customerTelephone;
	}

	public Integer getCustmerStatusCustomerId() {
		return custmerStatusCustomerId;
	}

	public void setCustmerStatusCustomerId(Integer custmerStatusCustomerId) {
		this.custmerStatusCustomerId = custmerStatusCustomerId;
	}

	public String getCustomerRemark() {
		return customerRemark;
	}

	public void setCustomerRemark(String customerRemark) {
		this.customerRemark = customerRemark;
	}

	public Integer getCdId() {
		return cdId;
	}

	public void setCdId(Integer cdId) {
		this.cdId = cdId;
	}

	public Date getAllocationTime() {
		return allocationTime;
	}

	public void setAllocationTime(Date allocationTime) {
		this.allocationTime = allocationTime;
	}

	public Date getNextContactTime() {
		return nextContactTime;
	}

	public void setNextContactTime(Date nextContactTime) {
		this.nextContactTime = nextContactTime;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
}
