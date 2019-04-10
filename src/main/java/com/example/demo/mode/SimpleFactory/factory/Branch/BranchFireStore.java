package com.example.demo.mode.SimpleFactory.factory.Branch;

import com.example.demo.mode.SimpleFactory.emnu.RiceSize;
import com.example.demo.mode.SimpleFactory.factory.MainRestaurantFactory;
import com.example.demo.mode.SimpleFactory.produce.SteamedRice;
import lombok.extern.slf4j.Slf4j;

/**
 * 炸鸡分店
 */
@Slf4j
public class BranchFireStore implements MainRestaurantFactory{

    // 做饭 可自配参数
    public <T extends SteamedRice> T makeRice(String taste, RiceSize size){
        return null;
    }
}
