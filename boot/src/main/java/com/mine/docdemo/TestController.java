package com.mine.docdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weapon
 * @date 2020/4/29 16:49
 */
@RestController
public class TestController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/t")
    public String test() {
        System.out.println("test"+port);
        return "SUCCESS";
    }
}
