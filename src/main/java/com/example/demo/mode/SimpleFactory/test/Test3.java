package com.example.demo.mode.SimpleFactory.test;

import com.example.demo.mode.SimpleFactory.emnu.RiceSize;
import com.example.demo.mode.SimpleFactory.factory.Branch.BranchBarbecueStore;
import com.example.demo.mode.SimpleFactory.factory.MainRestaurantFactory;
import com.example.demo.mode.SimpleFactory.produce.BarbecueRice;

/**
 *
 */
public class Test3 {

    public static void main(String[] args){
        // 来份烤肉拌饭
        BranchBarbecueStore barFactory = MainRestaurantFactory.createFactory(BranchBarbecueStore.class);
        if(barFactory != null){
            BarbecueRice barbecueRice = barFactory.makeRice("香辣", RiceSize.Big);
            barbecueRice.getRiceName();
            barbecueRice.getTaste();
            barbecueRice.getRiceSize();
        }
    }
}
