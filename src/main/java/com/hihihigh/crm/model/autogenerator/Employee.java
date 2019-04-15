package com.hihihigh.crm.model.autogenerator;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table employee
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class Employee {
    /**
     * Database Column Remarks:
     *   员工表主键-工号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.id
     *
     * @mbggenerated
     */
    private Integer id;

    public Employee() {
		super();
	}

	/**
     * Database Column Remarks:
     *   员工姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.employee_name
     *
     * @mbggenerated
     */
    private String employeeName;

    /**
     * Database Column Remarks:
     *   职位
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.employee_position_name
     *
     * @mbggenerated
     */
    private String employeePositionName;

    /**
     * Database Column Remarks:
     *   员工手机
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.employee_cellphone
     *
     * @mbggenerated
     */
    private String employeeCellphone;

    /**
     * Database Column Remarks:
     *   办公电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.employee_telephone
     *
     * @mbggenerated
     */
    private String employeeTelephone;

    /**
     * Database Column Remarks:
     *   在职状态 0在职 1离职
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.employee_status
     *
     * @mbggenerated
     */
    private Integer employeeStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.id
     *
     * @return the value of employee.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.id
     *
     * @param id the value for employee.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.employee_name
     *
     * @return the value of employee.employee_name
     *
     * @mbggenerated
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.employee_name
     *
     * @param employeeName the value for employee.employee_name
     *
     * @mbggenerated
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.employee_position_name
     *
     * @return the value of employee.employee_position_name
     *
     * @mbggenerated
     */
    public String getEmployeePositionName() {
        return employeePositionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.employee_position_name
     *
     * @param employeePositionName the value for employee.employee_position_name
     *
     * @mbggenerated
     */
    public void setEmployeePositionName(String employeePositionName) {
        this.employeePositionName = employeePositionName == null ? null : employeePositionName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.employee_cellphone
     *
     * @return the value of employee.employee_cellphone
     *
     * @mbggenerated
     */
    public String getEmployeeCellphone() {
        return employeeCellphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.employee_cellphone
     *
     * @param employeeCellphone the value for employee.employee_cellphone
     *
     * @mbggenerated
     */
    public void setEmployeeCellphone(String employeeCellphone) {
        this.employeeCellphone = employeeCellphone == null ? null : employeeCellphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.employee_telephone
     *
     * @return the value of employee.employee_telephone
     *
     * @mbggenerated
     */
    public String getEmployeeTelephone() {
        return employeeTelephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.employee_telephone
     *
     * @param employeeTelephone the value for employee.employee_telephone
     *
     * @mbggenerated
     */
    public void setEmployeeTelephone(String employeeTelephone) {
        this.employeeTelephone = employeeTelephone == null ? null : employeeTelephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.employee_status
     *
     * @return the value of employee.employee_status
     *
     * @mbggenerated
     */
    public Integer getEmployeeStatus() {
        return employeeStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.employee_status
     *
     * @param employeeStatus the value for employee.employee_status
     *
     * @mbggenerated
     */
    public void setEmployeeStatus(Integer employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", employeePositionName="
				+ employeePositionName + ", employeeCellphone=" + employeeCellphone + ", employeeTelephone="
				+ employeeTelephone + ", employeeStatus=" + employeeStatus + "]";
	}

	public Employee(String employeeName, String employeePositionName, String employeeCellphone,
			String employeeTelephone) {
		super();
		this.employeeName = employeeName;
		this.employeePositionName = employeePositionName;
		this.employeeCellphone = employeeCellphone;
		this.employeeTelephone = employeeTelephone;
	}
    
}