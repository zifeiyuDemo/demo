package com.example.demo.mode.ProxyMode.interfaces.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Dynamic proxy
 */
public class UserManagerProxyD {

    private Object target;

    public UserManagerProxyD(Object target){
        this.target = target;
    }

    // 方法返回一个代理
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("begin to call target");
                        Object obj = method.invoke(target, args);
                        return obj;
                    }
                }
        );
    }
}
