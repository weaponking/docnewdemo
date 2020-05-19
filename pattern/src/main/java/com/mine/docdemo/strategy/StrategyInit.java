package com.mine.docdemo.strategy;

import org.springframework.stereotype.Component;

@Component
public class StrategyInit implements IStrategy {

    @Override
    public boolean support(States states) {
        if(States.STATE_INIT == states) {
            return true;
        }
        return false;
    }

    @Override
    public void doService(TestVo testVo) {
        System.out.println("StrategyInit do");
    }
}
