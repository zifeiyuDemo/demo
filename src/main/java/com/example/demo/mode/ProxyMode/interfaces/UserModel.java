package com.example.demo.mode.ProxyMode.interfaces;

/**
 * not interface
 */
public class UserModel {

    private String name = "二黑";

    public void getMemberName(String name){
        this.name = name;
        System.out.println("user name = " + this.name);
    }
}
