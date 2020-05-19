package com.mine.docdemo.strategy;

public interface IStrategy {

    boolean support(States states);

    void doService(TestVo testVo);

}
