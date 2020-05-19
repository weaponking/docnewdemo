package com.mine.docdemo.controller;

import com.mine.docdemo.common.StateNotSupportException;
import com.mine.docdemo.strategy.States;
import com.mine.docdemo.strategy.StrategyService;
import com.mine.docdemo.strategy.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UrlController {

    @Autowired
    private StrategyService strategyService;

    @GetMapping("/t")
    public TestVo test() {
        TestVo testVo = new TestVo();
        testVo.setId(1l);
        testVo.setName("test");
        testVo.setStates(States.STATE_ANALYSIS);
        strategyService.doService(testVo);
        return testVo;
    }

//    @ExceptionHandler(StateNotSupportException.class)
//    public Map<String, Object> handle(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("msg", e.getMessage());
//        map.put("code", HttpStatus.BAD_REQUEST);
//        return map;
//    }

}
