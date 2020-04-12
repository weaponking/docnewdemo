package com.mine.docdemo.proxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * @author weapon
 * @date 2020/4/8 17:13
 */
@Slf4j
public class SourceInterceptor implements MethodInterceptor {

    private ISource source;

    public SourceInterceptor(ISource source) {
        this.source = source;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("intercept before");
        Object ret = method.invoke(source, objects);
        log.info("intercept after");
        return ret;
    }
}
