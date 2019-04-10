package com.example.demo.mode.ProxyMode.test;

import com.example.demo.mode.ProxyMode.interfaces.UserManager;
import com.example.demo.mode.ProxyMode.interfaces.impl.UserManagerImpl;
import com.example.demo.mode.ProxyMode.interfaces.impl.UserManagerProxyImpl;

/**
 * static test
 */
public class Test1 {

    public static void main(String[] args){
        // static test
        UserManager target = new UserManagerImpl();
        UserManager proxy = new UserManagerProxyImpl(target);
        proxy.getUserName();

    }
}
