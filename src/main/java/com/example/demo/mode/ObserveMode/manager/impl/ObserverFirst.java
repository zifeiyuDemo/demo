package com.example.demo.mode.ObserveMode.manager.impl;

import com.example.demo.mode.ObserveMode.manager.Observe;

/**
 * 守望者1号
 */
public class ObserverFirst implements Observe{

    private String observerName = "守望者一号";

    @Override
    public void detailMsg(String name, String message){
        System.out.println(observerName + "发现" + name + message);
    }
}
