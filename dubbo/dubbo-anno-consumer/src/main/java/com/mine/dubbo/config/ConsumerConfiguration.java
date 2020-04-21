package com.mine.dubbo.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @author weapon
 * @date 2020/3/29 11:33
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.mine.dubbo.service")
@PropertySource(value = {"classpath:dubbo-config.properties"})
@ComponentScan("com.mine.dubbo")
public class ConsumerConfiguration {

    @Value("${dubbo.appname}")
    private String appName;
    @Value("${dubbo.address}")
    private String address;

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(appName);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(address);
        return registryConfig;
    }
}
