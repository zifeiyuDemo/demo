package com.example.demo.mode.adapter.interfaces;

import com.example.demo.mode.adapter.interfaces.impl.Usber;

/**
 * 类适配
 */
public class Adapter1 extends Usber implements Ps2 {

    @Override
    public void sysType(){
        tellType();
    }
}
