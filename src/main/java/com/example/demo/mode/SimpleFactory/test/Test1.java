package com.example.demo.mode.SimpleFactory.test;

import com.example.demo.mode.SimpleFactory.emnu.RiceSize;
import com.example.demo.mode.SimpleFactory.factory.Restaurant2Factory;
import com.example.demo.mode.SimpleFactory.produce.SteamedRice;

/**
 */
public class Test1 {

    public static void main(String[] args){
        //
        System.out.println("来一份大的烤肉拌饭");
        SteamedRice steamedRice = Restaurant2Factory.createBarbRice(RiceSize.Big);
        steamedRice.getRiceName();
        steamedRice.getRiceSize();
    }
}
