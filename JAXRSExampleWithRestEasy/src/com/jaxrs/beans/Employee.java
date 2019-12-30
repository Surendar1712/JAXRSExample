package com.jaxrs.beans;

import java.sql.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.jaxrs.util.DateAdapter;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

  @XmlElement(name="employeeId")
  private int employeeId;

  @XmlElement(name="employeeName")
  private String employeeName;
  
  @XmlElement(name="salary")
  private Long salary;
  
  @XmlElement(name="deptId")
  private int deptId;

  @XmlElement(name="joiningDate")
  @XmlJavaTypeAdapter(DateAdapter.class)
  private Date joiningDate;

  public Employee() {
  }

  public Employee(int employeeId, String employeeName, Long salary, int deptId, Date joiningDate) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.salary = salary;
    this.deptId = deptId;
    this.joiningDate = joiningDate;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public Long getSalary() {
    return salary;
  }

  public void setSalary(Long salary) {
    this.salary = salary;
  }

  public int getDeptId() {
    return deptId;
  }

  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }

  public Date getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(Date joiningDate) {
    this.joiningDate = joiningDate;
  }

  @Override
  public String toString() {
    return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary + ", deptId="
        + deptId + ", joiningDate=" + joiningDate + "]";
  }

}
