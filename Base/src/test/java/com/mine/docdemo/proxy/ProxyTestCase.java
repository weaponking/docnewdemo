package com.mine.docdemo.proxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author weapon
 * @date 2020/4/8 17:00
 */
@Slf4j
public class ProxyTestCase {

    private ISource source = null;
    private StaticProxy staticProxy;
    private SourceHandler sourceProxy;
    private SourceInterceptor sourceInterceptor;

    @Before
    public void before() {
        source = new SourceImpl();
        staticProxy = new StaticProxy(source);
        sourceProxy = new SourceHandler(source);
        sourceInterceptor = new SourceInterceptor(source);
    }

    @Test
    public void test() {
        String ret = staticProxy.test();
        log.info(ret);
    }

    @Test
    public void test1() {
        ISource hanlderSource = (ISource) Proxy.newProxyInstance(sourceProxy.getClass().getClassLoader(),
            source.getClass().getInterfaces(), sourceProxy);
        String ret = hanlderSource.test();
        log.info(ret);
    }

    @Test
    public void test2() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(source.getClass());
        enhancer.setCallback(sourceInterceptor);
        ISource InterceptSource = (ISource) enhancer.create();
        String ret = InterceptSource.test();
        log.info(ret);
    }

    @Test
    public void test3() {
        ImplProxy implProxy = new ImplProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ImplProxy.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                log.info("ImplProxy before");
                Object ret = method.invoke(implProxy, objects);
                log.info("ImplProxy after");
                return ret;
            }
        });

        ImplProxy proxy = (ImplProxy) enhancer.create();
        log.info(proxy.test());
    }

}
