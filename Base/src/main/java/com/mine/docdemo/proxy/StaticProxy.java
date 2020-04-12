package com.mine.docdemo.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author weapon
 * @date 2020/4/8 16:53
 */
@Slf4j
public class StaticProxy {

    private ISource source;

    public StaticProxy(ISource source) {
        this.source = source;
    }

    public String test() {
        log.info("test before");
        String ret = source.test();
        log.info("test after");
        return ret;
    }
}
