package com.sample.highcharts.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebMvpInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(SpringConfig.class);
    ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
    registration.addMapping("/");
    registration.setLoadOnStartup(1);
  }
}
