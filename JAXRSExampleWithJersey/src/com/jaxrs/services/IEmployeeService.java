package com.jaxrs.services;

import java.util.List;
import com.jaxrs.beans.Employee;
import com.jaxrs.beans.Response;

public interface IEmployeeService {

  public Response addEmployee(Employee employee);

  public Response deleteEmployee(int employeeId);

  public Employee getEmployee(int employeeId);

  public List<Employee> getEmployeeList();
}
