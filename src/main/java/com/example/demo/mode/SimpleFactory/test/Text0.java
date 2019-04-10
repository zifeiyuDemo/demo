package com.example.demo.mode.SimpleFactory.test;

import com.example.demo.mode.SimpleFactory.emnu.RiceType;
import com.example.demo.mode.SimpleFactory.factory.RestaurantFactory;
import com.example.demo.mode.SimpleFactory.produce.SteamedRice;

/**
 * test taste rice
 */
public class Text0 {

    public static  void main(String[] args){
        // 今天周一 吃烤肉拌饭
        SteamedRice barbecueRice = RestaurantFactory.createRice(RiceType.Barbecue);
        barbecueRice.getRiceName();
        barbecueRice.getTaste();
        barbecueRice.getPractice();

        System.out.println("******分割割割割割割割割割割割*****");

        SteamedRice fireRice = RestaurantFactory.createRice(RiceType.FriedRice);
        fireRice.getRiceName();
        fireRice.getTaste();
        fireRice.getPractice();
    }
}
