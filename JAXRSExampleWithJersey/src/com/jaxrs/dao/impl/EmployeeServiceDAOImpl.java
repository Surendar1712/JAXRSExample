package com.jaxrs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.jaxrs.beans.Employee;
import com.jaxrs.dao.IEmployeeServiceDAO;
import com.jaxrs.util.DBHelper;

public class EmployeeServiceDAOImpl implements IEmployeeServiceDAO {

  @Override
  public boolean addEmployee(Employee employee) {
    System.out.println("addEmployee employee :" + employee);
    boolean insertedFlag = false;
    try (Connection conn = DBHelper.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
            "insert into employee_details(EMPLOYEE_ID, EMPLOYEE_NAME, SALARY, DEPT_ID, JOINING_DATE) values(?, ?, ?, ?, ?)");) {
      pstmt.setInt(1, employee.getEmployeeId());
      pstmt.setString(2, employee.getEmployeeName());
      pstmt.setLong(3, employee.getSalary());
      pstmt.setInt(4, employee.getDeptId());
      pstmt.setDate(5, employee.getJoiningDate());

      int count = pstmt.executeUpdate();
      System.out.println("Inserted count :" + count);
      insertedFlag = count > 0 ? true : false;
    } catch (SQLException se) {
      se.printStackTrace();
    }
    return insertedFlag;
  }

  @Override
  public boolean deleteEmployee(int employeeId) {
    System.out.println("deleteEmployee employeeId :" + employeeId);
    boolean deletedFlag = false;
    try (Connection conn = DBHelper.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("delete from employee_details where EMPLOYEE_ID = ?");) {
      pstmt.setInt(1, employeeId);

      int count = pstmt.executeUpdate();
      System.out.println("Deleted count :" + count);
      deletedFlag = count > 0 ? true : false;
    } catch (SQLException se) {
      se.printStackTrace();
    }
    return deletedFlag;
  }

  @Override
  public Employee getEmployee(int employeeId) {
    System.out.println("getEmployee employeeId :" + employeeId);
    Employee employee = null;
    try (Connection conn = DBHelper.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
            "select EMPLOYEE_ID, EMPLOYEE_NAME, SALARY, DEPT_ID, JOINING_DATE from employee_details where employee_id = ?");) {
      pstmt.setInt(1, employeeId);

      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        employee = new Employee();
        employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
        employee.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
        employee.setSalary(rs.getLong("SALARY"));
        employee.setDeptId(rs.getInt("DEPT_ID"));
        employee.setJoiningDate(rs.getDate("JOINING_DATE"));
      }
      System.out.println("employee :" + employee);
    } catch (SQLException se) {
      se.printStackTrace();
    }
    return employee;
  }

  @Override
  public List<Employee> getEmployeeList() {
    System.out.println("getEmployeeList method called");
    List<Employee> employeeList = new ArrayList<>();
    try (Connection conn = DBHelper.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
            "select EMPLOYEE_ID, EMPLOYEE_NAME, SALARY, DEPT_ID, JOINING_DATE from employee_details");) {

      ResultSet rs = pstmt.executeQuery();
      Employee employee = null;
      while (rs.next()) {
        employee = new Employee();
        employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
        employee.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
        employee.setSalary(rs.getLong("SALARY"));
        employee.setDeptId(rs.getInt("DEPT_ID"));
        employee.setJoiningDate(rs.getDate("JOINING_DATE"));
        employeeList.add(employee);
      }
      System.out.println("employeeList :" + employeeList);
    } catch (SQLException se) {
      se.printStackTrace();
    }
    return employeeList;
  }

}
