package com.example.demo.mode.SimpleFactory.factory.Branch;

import com.example.demo.mode.SimpleFactory.emnu.RiceSize;
import com.example.demo.mode.SimpleFactory.factory.MainRestaurantFactory;
import com.example.demo.mode.SimpleFactory.produce.BarbecueRice;
import com.example.demo.mode.SimpleFactory.produce.SteamedRice;
import lombok.extern.slf4j.Slf4j;

/**
 * 烤肉分店
 */
@Slf4j
public class BranchBarbecueStore implements MainRestaurantFactory {

    public <T extends SteamedRice> T makeRice(String taste, RiceSize size){
        return (T) BarbecueRice.of(taste, RiceSize.Big);
    }

}
