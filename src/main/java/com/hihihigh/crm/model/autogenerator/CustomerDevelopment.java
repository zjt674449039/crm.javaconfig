package com.hihihigh.crm.model.autogenerator;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table customer_development
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class CustomerDevelopment {
    /**
     * Database Column Remarks:
     *   客户开发表主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_development.id
     *
     * @mbggenerated
     */
    private Integer id;

    public CustomerDevelopment(int cdId, Date nextContactTime) {
    	id = cdId;
    	this.nextContactTime = nextContactTime;
    }

	public CustomerDevelopment() {
		super();
	}

	@Override
	public String toString() {
		return "CustomerDevelopment [id=" + id + ", cdCustomerId=" + cdCustomerId + ", allocationTime=" + allocationTime
				+ ", nextContactTime=" + nextContactTime + ", lastContactTime=" + lastContactTime + ", cdEmployeeId="
				+ cdEmployeeId + ", validCellphone=" + validCellphone + ", pickedPhone=" + pickedPhone + "]";
	}

	/**
     * Database Column Remarks:
     *   客户表id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_development.cd_customer_id
     *
     * @mbggenerated
     */
    private Integer cdCustomerId;

    /**
     * Database Column Remarks:
     *   分配时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_development.allocation_time
     *
     * @mbggenerated
     */
    private Date allocationTime;

    /**
     * Database Column Remarks:
     *   计划联系时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_development.next_contact_time
     *
     * @mbggenerated
     */
    private Date nextContactTime;

    /**
     * Database Column Remarks:
     *   上次联系时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_development.last_contact_time
     *
     * @mbggenerated
     */
    private Date lastContactTime;

    /**
     * Database Column Remarks:
     *   员工表id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_development.cd_employee_id
     *
     * @mbggenerated
     */
    private Integer cdEmployeeId;

    /**
     * Database Column Remarks:
     *   0有效 1无效
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_development.valid_cellphone
     *
     * @mbggenerated
     */
    private Integer validCellphone;

    /**
     * Database Column Remarks:
     *   0接通 1未接通
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_development.picked_phone
     *
     * @mbggenerated
     */
    private Integer pickedPhone;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_development.id
     *
     * @return the value of customer_development.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_development.id
     *
     * @param id the value for customer_development.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_development.cd_customer_id
     *
     * @return the value of customer_development.cd_customer_id
     *
     * @mbggenerated
     */
    public Integer getCdCustomerId() {
        return cdCustomerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_development.cd_customer_id
     *
     * @param cdCustomerId the value for customer_development.cd_customer_id
     *
     * @mbggenerated
     */
    public void setCdCustomerId(Integer cdCustomerId) {
        this.cdCustomerId = cdCustomerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_development.allocation_time
     *
     * @return the value of customer_development.allocation_time
     *
     * @mbggenerated
     */
    public Date getAllocationTime() {
        return allocationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_development.allocation_time
     *
     * @param allocationTime the value for customer_development.allocation_time
     *
     * @mbggenerated
     */
    public void setAllocationTime(Date allocationTime) {
        this.allocationTime = allocationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_development.next_contact_time
     *
     * @return the value of customer_development.next_contact_time
     *
     * @mbggenerated
     */
    public Date getNextContactTime() {
        return nextContactTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_development.next_contact_time
     *
     * @param nextContactTime the value for customer_development.next_contact_time
     *
     * @mbggenerated
     */
    public void setNextContactTime(Date nextContactTime) {
        this.nextContactTime = nextContactTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_development.last_contact_time
     *
     * @return the value of customer_development.last_contact_time
     *
     * @mbggenerated
     */
    public Date getLastContactTime() {
        return lastContactTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_development.last_contact_time
     *
     * @param lastContactTime the value for customer_development.last_contact_time
     *
     * @mbggenerated
     */
    public void setLastContactTime(Date lastContactTime) {
        this.lastContactTime = lastContactTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_development.cd_employee_id
     *
     * @return the value of customer_development.cd_employee_id
     *
     * @mbggenerated
     */
    public Integer getCdEmployeeId() {
        return cdEmployeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_development.cd_employee_id
     *
     * @param cdEmployeeId the value for customer_development.cd_employee_id
     *
     * @mbggenerated
     */
    public void setCdEmployeeId(Integer cdEmployeeId) {
        this.cdEmployeeId = cdEmployeeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_development.valid_cellphone
     *
     * @return the value of customer_development.valid_cellphone
     *
     * @mbggenerated
     */
    public Integer getValidCellphone() {
        return validCellphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_development.valid_cellphone
     *
     * @param validCellphone the value for customer_development.valid_cellphone
     *
     * @mbggenerated
     */
    public void setValidCellphone(Integer validCellphone) {
        this.validCellphone = validCellphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_development.picked_phone
     *
     * @return the value of customer_development.picked_phone
     *
     * @mbggenerated
     */
    public Integer getPickedPhone() {
        return pickedPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_development.picked_phone
     *
     * @param pickedPhone the value for customer_development.picked_phone
     *
     * @mbggenerated
     */
    public void setPickedPhone(Integer pickedPhone) {
        this.pickedPhone = pickedPhone;
    }
}