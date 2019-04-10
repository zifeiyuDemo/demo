package com.example.demo.mode.ProxyMode.interfaces.impl;

import com.example.demo.mode.ProxyMode.interfaces.UserManager;

/**
 * static proxy
 */
public class UserManagerProxyImpl implements UserManager{

    private UserManager target;

    public  UserManagerProxyImpl(UserManager target){
        this.target = target;
    }

    public void getUserName(){
        System.out.println("ready to call target");
        target.getUserName();
    }
}
