package com.mine.dubbo;

import com.mine.dubbo.config.ProviderConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author weapon
 * @date 2020/3/29 12:09
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ProviderConfiguration.class);
        context.refresh();

        while (true) {

        }
    }
}
