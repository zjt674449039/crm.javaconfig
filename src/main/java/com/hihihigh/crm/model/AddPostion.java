package com.hihihigh.crm.model;

import java.util.Arrays;

public class AddPostion {
	private String positionName;
	private Integer positionDepartmentId;
	private Integer[] authorityNameAuthorityIds;

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Integer getPositionDepartmentId() {
		return positionDepartmentId;
	}

	public void setPositionDepartmentId(Integer positionDepartmentId) {
		this.positionDepartmentId = positionDepartmentId;
	}

	public Integer[] getAuthorityNameAuthorityIds() {
		return authorityNameAuthorityIds;
	}

	public void setAuthorityNameAuthorityIds(Integer[] authorityNameAuthorityIds) {
		this.authorityNameAuthorityIds = authorityNameAuthorityIds;
	}

	@Override
	public String toString() {
		return "AddPostion [positionName=" + positionName + ", positionDepartmentId=" + positionDepartmentId
				+ ", authorityNameAuthorityIds=" + Arrays.toString(authorityNameAuthorityIds) + "]";
	}

	public AddPostion(String positionName, Integer positionDepartmentId, Integer[] authorityNameAuthorityIds) {
		super();
		this.positionName = positionName;
		this.positionDepartmentId = positionDepartmentId;
		this.authorityNameAuthorityIds = authorityNameAuthorityIds;
	}

	public AddPostion() {
		super();
	}
}
