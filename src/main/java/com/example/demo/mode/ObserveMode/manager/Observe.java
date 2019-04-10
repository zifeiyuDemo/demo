package com.example.demo.mode.ObserveMode.manager;

/**
 * 观察者
 * 接收消息 且处理方法
 */
public interface Observe {

    void detailMsg(String name, String message);
}
