package com.jaxrs.services.impl;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.jaxrs.beans.Employee;
import com.jaxrs.beans.Response;
import com.jaxrs.dao.IEmployeeServiceDAO;
import com.jaxrs.dao.impl.EmployeeServiceDAOImpl;
import com.jaxrs.services.IEmployeeService;

@Path("/employee-service")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeServiceImpl implements IEmployeeService {

  @Override
  @POST
  @Path("/add")
  public Response addEmployee(Employee employee) {
    System.out.println("addEmployee employee :" + employee);
    IEmployeeServiceDAO employeeDAO = new EmployeeServiceDAOImpl();
    boolean insertedFlag = employeeDAO.addEmployee(employee);
    Response response = new Response();
    response.setStatus(insertedFlag);
    response.setMessage(insertedFlag ? "SUCCESS" : "FAILURE");
    return response;
  }

  @Override
  @GET
  @Path("/{id}/delete")
  public Response deleteEmployee(@PathParam("id") int employeeId) {
    System.out.println("deleteEmployee employeeId :" + employeeId);
    IEmployeeServiceDAO employeeDAO = new EmployeeServiceDAOImpl();
    boolean deletedFlag = employeeDAO.deleteEmployee(employeeId);
    Response response = new Response();
    response.setStatus(deletedFlag);
    response.setMessage(deletedFlag ? "SUCCESS" : "FAILURE");
    return response;
  }

  @Override
  @GET
  @Path("/{id}/get")
  public Employee getEmployee(@PathParam("id") int employeeId) {
    System.out.println("getEmployee employeeId :" + employeeId);
    IEmployeeServiceDAO employeeDAO = new EmployeeServiceDAOImpl();
    return employeeDAO.getEmployee(employeeId);
  }

  @Override
  @GET
  @Path("/getAll")
  public List<Employee> getEmployeeList() {
    System.out.println("getEmployeeList method called");
    IEmployeeServiceDAO employeeDAO = new EmployeeServiceDAOImpl();
    return employeeDAO.getEmployeeList();
  }

}
