package com.example.demo.mode.adapter.test;

import com.example.demo.mode.adapter.interfaces.Adapter1;
import com.example.demo.mode.adapter.interfaces.Ps2;

import java.util.Date;

/**
 */
public class Test1 {

    public static void main(String[] args){
        // test class adapter
        Ps2 ps2 = new Adapter1();
        ps2.sysType();
    }
}
