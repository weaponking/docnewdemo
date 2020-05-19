package com.mine.docdemo.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategyAnalysis implements IStrategy {

    @Override
    public boolean support(States states) {
        if(States.STATE_ANALYSIS == states) {
            return true;
        }
        return false;
    }

    @Override
    public void doService(TestVo testVo) {
        System.out.println("StrategyAnalysis do");
    }
}
