package com.kgc.dao;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理类方法执行的逻辑
 * 会将被代理类的所有方法 按照此逻辑进行代理 也可以按照 method方法名进行判断
 * methodProxy.invokeSuper(o,objects) 调用父类的方法  将参数传递进去
 */
public class Proxyhandler implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib");
        return methodProxy.invokeSuper(o,objects);
    }
}
