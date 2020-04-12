package com.mine.dubbo.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author weapon
 * @date 2020/3/29 11:33
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.mine.dubbo.service")
@ImportResource(locations = {"classpath:provider.xml"})
public class ProviderConfiguration {
}
