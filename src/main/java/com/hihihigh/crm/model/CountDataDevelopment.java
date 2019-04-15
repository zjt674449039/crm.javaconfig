package com.hihihigh.crm.model;

public class CountDataDevelopment {
	private Integer newCount;
	private Integer beenCount;
	private Integer failCalledCount;
	private Integer badCellPhoneCount;
	private Integer deadCount;
	private Integer followingCount;
	private Integer totalCount;

	public Integer getNewCount() {
		return newCount;
	}

	public void setNewCount(Integer newCount) {
		this.newCount = newCount;
	}

	public Integer getBeenCount() {
		return beenCount;
	}

	public void setBeenCount(Integer beenCount) {
		this.beenCount = beenCount;
	}

	public Integer getFailCalledCount() {
		return failCalledCount;
	}

	public void setFailCalledCount(Integer failCalledCount) {
		this.failCalledCount = failCalledCount;
	}

	public Integer getBadCellPhoneCount() {
		return badCellPhoneCount;
	}

	public void setBadCellPhoneCount(Integer badCellPhoneCount) {
		this.badCellPhoneCount = badCellPhoneCount;
	}

	public Integer getDeadCount() {
		return deadCount;
	}

	public void setDeadCount(Integer deadCount) {
		this.deadCount = deadCount;
	}

	public Integer getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "CountDataDevelopment [newCount=" + newCount + ", beenCount=" + beenCount + ", failCalledCount="
				+ failCalledCount + ", badCellPhoneCount=" + badCellPhoneCount + ", deadCount=" + deadCount
				+ ", followingCount=" + followingCount + ", totalCount=" + totalCount + "]";
	}

	public CountDataDevelopment(Integer newCount, Integer beenCount, Integer failCalledCount, Integer badCellPhoneCount,
			Integer deadCount, Integer followingCount, Integer totalCount) {
		super();
		this.newCount = newCount;
		this.beenCount = beenCount;
		this.failCalledCount = failCalledCount;
		this.badCellPhoneCount = badCellPhoneCount;
		this.deadCount = deadCount;
		this.followingCount = followingCount;
		this.totalCount = totalCount;
	}

	public CountDataDevelopment() {
		super();
	}
}
