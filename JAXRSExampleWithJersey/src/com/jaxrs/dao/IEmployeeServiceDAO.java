package com.jaxrs.dao;

import java.util.List;
import com.jaxrs.beans.Employee;

public interface IEmployeeServiceDAO {

  public boolean addEmployee(Employee employee);

  public boolean deleteEmployee(int employeeId);

  public Employee getEmployee(int employeeId);

  public List<Employee> getEmployeeList();
}
