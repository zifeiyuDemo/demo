package com.example.demo.mode.ProxyMode.test;

import com.example.demo.mode.ProxyMode.interfaces.UserModel;
import com.example.demo.mode.ProxyMode.interfaces.impl.UserManagerProxyS;

/**
 *
 * cglib proxy
 */
public class Test3 {

    public static void main(String[] args){
        UserModel userModel = new UserModel();

        UserModel proxy = (UserModel) new UserManagerProxyS(userModel).getProxyInstance();

        proxy.getMemberName("大傻");

    }
}
