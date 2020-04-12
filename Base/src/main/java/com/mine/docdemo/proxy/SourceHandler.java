package com.mine.docdemo.proxy;

import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author weapon
 * @date 2020/4/8 16:59
 */
@Slf4j
public class SourceHandler<ISource> implements InvocationHandler {

    private ISource source;

    public SourceHandler(ISource source) {
        this.source = source;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("invoke before");
        Object ret = method.invoke(source, args);
        log.info("invoke after");
        return ret;
    }

}
