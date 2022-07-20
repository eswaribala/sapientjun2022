package com.sapient.gloalinsurancespringmvcapp.configurations;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
@Configuration
@ComponentScan(basePackages={"com.sapient.gloalinsurancespringmvcapp.*"})
public class GlobalInsuranceWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // TODO Auto-generated method stub
        AnnotationConfigWebApplicationContext appContext =
                new AnnotationConfigWebApplicationContext();
        //appContext.register(LoggingHandler.class);
        appContext.register(GlobalInsuranceMVCConfigurer.class);
        //appContext.refresh();
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "SpringDispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

}