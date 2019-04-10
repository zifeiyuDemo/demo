package com.example.demo.mode.ObserveMode.manager.impl;

import com.example.demo.mode.ObserveMode.manager.Observe;

/**
 * 守望者2号
 */
public class ObserverSecond implements Observe {

    private String observerName = "守望者二号";

    @Override
    public void detailMsg(String name, String message){
        System.out.println(observerName + "发现" + name + message);
    }
}
