package com.stackroute.muzixapp.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//configuration class
@Configuration
public class WebConfiguration {
    //bean for console (h2Servletregistration)
    @Bean
    ServletRegistrationBean h2servletregistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
