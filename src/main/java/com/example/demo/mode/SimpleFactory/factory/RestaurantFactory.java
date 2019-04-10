package com.example.demo.mode.SimpleFactory.factory;

import com.example.demo.mode.SimpleFactory.emnu.RiceType;
import com.example.demo.mode.SimpleFactory.produce.BarbecueRice;
import com.example.demo.mode.SimpleFactory.produce.FriedChicken;
import com.example.demo.mode.SimpleFactory.produce.SteamedRice;

/**
 * 简单实体工厂方法类
 */
public class RestaurantFactory {

    // 不支持初始化带有参数的实际饭
    public static SteamedRice createRice(RiceType type){
        switch (type){
            case Barbecue:
                return new BarbecueRice();
            case FriedRice:
                return new FriedChicken();
            default:
                return new BarbecueRice();
        }
    }
}
