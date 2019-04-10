package com.example.demo.mode.stateMode.manager.impl;

import com.example.demo.mode.stateMode.Machine;
import com.example.demo.mode.stateMode.manager.State;


public class InitState implements State {

    // 持有的机器
    private Machine machine;

    public InitState(Machine machine){
        this.machine = machine;
    }

    @Override
    public void insertCoin(){
        System.out.println("current has a coin , do not insert second");
    }

    @Override
    public void returnCoin(){
        System.out.println("now to return coin , wait a moment");
    }

    @Override
    public void turnCrank(){
        // TODO  实现运行方法
    }

    @Override
    public void dispatch(){

    }

    // 输出状态
    @Override
    public void printState(){
        System.out.println("******Has Coin*****");
    }
}
