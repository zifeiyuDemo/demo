package com.example.demo.mode.ProxyMode.test;

import com.example.demo.mode.ProxyMode.interfaces.UserManager;
import com.example.demo.mode.ProxyMode.interfaces.impl.UserManagerImpl;
import com.example.demo.mode.ProxyMode.interfaces.impl.UserManagerProxyD;

/**
 * Dynamic Test2
 */
public class Test2 {

    public static void main(String[] args){

        UserManager target = new UserManagerImpl();
        UserManager proxyD = (UserManager) new UserManagerProxyD(target).getProxyInstance();
        proxyD.getUserName();
    }
}
