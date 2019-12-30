package com.jaxrs.app;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import com.jaxrs.services.impl.EmployeeServiceImpl;

public class MyApp extends Application {

  private Set<Object> singletons = new HashSet<Object>();

  public MyApp() {
    singletons.add(new EmployeeServiceImpl());
  }

  @Override
  public Set<Object> getSingletons() {
    return singletons;
  }
}
