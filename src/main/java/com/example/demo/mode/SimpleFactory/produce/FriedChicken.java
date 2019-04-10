package com.example.demo.mode.SimpleFactory.produce;

import com.example.demo.mode.SimpleFactory.emnu.RiceSize;
import lombok.NoArgsConstructor;

/**
 * 脆皮鸡拌饭
 */
@NoArgsConstructor
public class FriedChicken implements SteamedRice{

    private String riceSize;

    @Override
    public void getRiceName(){
        System.out.println("脆皮鸡拌饭");
    }

    @Override
    public void getTaste(){
        System.out.println("沙拉");
    }

    @Override
    public void getRiceSize(){
        System.out.println("饭量：" + riceSize);
    }

    @Override
    public void getPractice(){
        System.out.println("炸出来的");
    }

    public FriedChicken(RiceSize size){
        switch (size){
            case Big:
                riceSize = "大份";
            case Middle:
                riceSize = "中份";
            case Small:
                riceSize = "小份";
            default:
                riceSize = "随便";
        }

    }
}
