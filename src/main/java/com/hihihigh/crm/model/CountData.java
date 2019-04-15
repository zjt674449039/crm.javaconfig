package com.hihihigh.crm.model;

import java.util.List;

import com.hihihigh.crm.model.autogenerator.Employee;

/**
 * @author victor
 *
 */
public class CountData {
	private Integer employeeId;
	private String employeeName;
	private Integer newCount;
	private Integer followingCount;
	private Integer signedCount;
	private Integer deadCount;
	private Integer paybackCount;
	private Integer totalCount;

	public Integer getNewCount() {
		return newCount;
	}

	public void setNewCount(Integer newCount) {
		this.newCount = newCount;
	}

	public Integer getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}

	public Integer getSignedCount() {
		return signedCount;
	}

	public void setSignedCount(Integer signedCount) {
		this.signedCount = signedCount;
	}

	public Integer getDeadCount() {
		return deadCount;
	}

	public void setDeadCount(Integer deadCount) {
		this.deadCount = deadCount;
	}

	public Integer getPaybackCount() {
		return paybackCount;
	}

	public void setPaybackCount(Integer paybackCount) {
		this.paybackCount = paybackCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
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

	@Override
	public String toString() {
		return "CountDataCounselor [employeeId=" + employeeId + ", employeeName=" + employeeName + ", newCount="
				+ newCount + ", followingCount=" + followingCount + ", signedCount=" + signedCount + ", deadCount="
				+ deadCount + ", paybackCount=" + paybackCount + ", totalCount=" + totalCount + "]";
	}

	public CountData(Integer newCount, Integer followingCount, Integer signedCount, Integer deadCount,
			Integer paybackCount, Integer totalCount) {
		super();
		this.newCount = newCount;
		this.followingCount = followingCount;
		this.signedCount = signedCount;
		this.deadCount = deadCount;
		this.paybackCount = paybackCount;
		this.totalCount = totalCount;
	}

	public CountData() {
		super();
	}

	public CountData(Employee employee, List<Integer> countNumbers) {
		this.employeeId = employee.getId();
		this.employeeName = employee.getEmployeeName();
		this.newCount = countNumbers.get(0);
		this.followingCount = countNumbers.get(1);
		this.signedCount = countNumbers.get(2);
		this.deadCount = countNumbers.get(3);
		this.paybackCount = countNumbers.get(4);
		this.totalCount = newCount + followingCount + signedCount + deadCount + paybackCount;
	}
}
