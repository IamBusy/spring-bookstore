package com.william.configuration;

//import com.william.service.CategoryService;
//import org.apache.cxf.Bus;
//import org.apache.cxf.jaxws.EndpointImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Created by william on 08/05/2017.
 */
@Configuration
public class CxfConfig {

//    @Autowired
//    private Bus bus;
//
//    @Autowired
//    private CategoryService categoryService;
//
////    @Bean
////    public ServletRegistrationBean dispatcherServlet() {
////        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
////    }
////    @Bean(name = Bus.DEFAULT_BUS_ID)
////    public SpringBus springBus() {
////        return new SpringBus();
////    }
//
//    @Bean
//    public Endpoint endpoint() {
//        EndpointImpl endpoint = new EndpointImpl(bus, categoryService);
//        endpoint.publish("/categories");
//        return endpoint;
//    }
}
