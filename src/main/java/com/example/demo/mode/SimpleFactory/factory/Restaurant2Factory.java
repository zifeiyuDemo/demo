package com.example.demo.mode.SimpleFactory.factory;

import com.example.demo.mode.SimpleFactory.emnu.RiceSize;
import com.example.demo.mode.SimpleFactory.produce.BarbecueRice;
import com.example.demo.mode.SimpleFactory.produce.FriedChicken;
import com.example.demo.mode.SimpleFactory.produce.SteamedRice;

/**
 * 另一个饭店 这样就可以支持带有参数初始化了
 */
public class Restaurant2Factory {

    // 做一份烤肉拌饭
    public static SteamedRice createBarbRice(RiceSize size){
        SteamedRice barbRice = new BarbecueRice(size);
        return barbRice;
    }

    // 做一份脆皮鸡拌饭
    public static SteamedRice createFireRice(RiceSize size){
        SteamedRice fireRice = new FriedChicken(size);
        return fireRice;
    }
}
