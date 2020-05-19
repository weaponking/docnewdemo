package com.mine.docdemo.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCase implements CommandLineRunner {

    @Autowired
    private StrategyService strategyService;

    @Override
    public void run(String... args) throws Exception {
        TestVo testVo = new TestVo();
        testVo.setId(1l);
        testVo.setName("test");
        testVo.setStates(States.STATE_ANALYSIS);
        strategyService.doService(testVo);
    }
}
