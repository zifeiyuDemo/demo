package com.example.demo.mode.ProxyMode.interfaces.impl;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 子类代理
 * 当目标对象未实现接口时 使用
 */
public class UserManagerProxyS implements MethodInterceptor {

    private Object target;

    public UserManagerProxyS(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        // 工具类
        Enhancer en = new Enhancer();
        // 设置父类
        en.setSuperclass(target.getClass());
        // 设置回调函数
        en.setCallback(this);

        return en.create();
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object object = method.invoke(target, args);
        return object;
    }
}
