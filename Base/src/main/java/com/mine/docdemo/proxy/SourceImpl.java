package com.mine.docdemo.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author weapon
 * @date 2020/4/8 16:58
 */
@Slf4j
public class SourceImpl implements ISource {

    @Override
    public String test() {
        log.info("sourceimpl test");
        return "test";
    }
}
