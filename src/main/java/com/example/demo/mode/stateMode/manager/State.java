package com.example.demo.mode.stateMode.manager;

// 状态接口
public interface State {
    // 投币方法
    public void insertCoin();

    // 退币方法
    public void returnCoin();

    // 转动杆
    public void turnCrank();

    // 分发礼物
    public void dispatch();

    // 输出状态
    public void printState();
}
