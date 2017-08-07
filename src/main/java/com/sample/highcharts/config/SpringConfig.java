package com.sample.highcharts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.sample.highcharts")
public class SpringConfig extends WebMvcConfigurerAdapter {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
  }

  @Bean
  public InternalResourceViewResolver jspViewResolver() {
    InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
    viewResolve.setPrefix("/WEB-INF/jsp/");
    viewResolve.setSuffix(".jsp");
    viewResolve.setOrder(1);
    return viewResolve;
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.favorPathExtension(false).
      favorParameter(false).
      parameterName("mediaType").
      ignoreAcceptHeader(false).
      defaultContentType(MediaType.APPLICATION_JSON).
      mediaType("xml", MediaType.APPLICATION_XML).
      mediaType("json", MediaType.APPLICATION_JSON);
  }
}
