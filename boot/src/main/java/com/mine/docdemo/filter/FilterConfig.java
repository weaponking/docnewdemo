package com.mine.docdemo.filter;

import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new FilterB());
        registration.setUrlPatterns(Arrays.asList("/b"));
        return registration;
    }

    @Bean
    public DelegatingFilterProxyRegistrationBean delegatingFilterProxyRegistrationBean() {
        DelegatingFilterProxyRegistrationBean bean = new DelegatingFilterProxyRegistrationBean("filterD");
        bean.setUrlPatterns(Arrays.asList("/d"));
        return bean;
    }
}
