//package org.home.configs;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class MvcConfig implements WebMvcConfigurer {
//
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/index").setViewName("index");
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/login").setViewName("auth/login");
//        registry.addViewController("/login/success").setViewName("auth/success");
//        registry.addViewController("/login/failure").setViewName("auth/failure");
//    }
//
//}