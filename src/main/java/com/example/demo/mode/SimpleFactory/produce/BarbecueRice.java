package com.example.demo.mode.SimpleFactory.produce;

import com.example.demo.mode.SimpleFactory.emnu.RiceSize;
import lombok.NoArgsConstructor;

/**
 * 烤肉拌饭
 */
@NoArgsConstructor
public class BarbecueRice implements SteamedRice {

    private String taste;
    private String riceSize;

    @Override
    public void getRiceName() {
        System.out.println("烤肉拌饭");
    }

    @Override
    public void getTaste() {
        System.out.println("口味" + taste);
    }

    @Override
    public void getRiceSize(){
        System.out.println("饭量：" + riceSize);
    }

    @Override
    public  void getPractice() {
        System.out.println("烤出来的");
    }

    public BarbecueRice(RiceSize size){
        switch (size){
            case Big:
                riceSize = "大份";
                break;
            case Middle:
                riceSize = "中份";
                break;
            case Small:
                riceSize = "小份";
                break;
            default:
                riceSize = "随便";
        }
    }

    public static BarbecueRice of(String taste, RiceSize size){
        BarbecueRice barbecueRice = new BarbecueRice();
        barbecueRice.taste = taste;

        switch (size){
            case Big:
                barbecueRice.riceSize = "大份";
                break;
            case Middle:
                barbecueRice.riceSize = "中份";
                break;
            case Small:
                barbecueRice.riceSize = "小份";
                break;
            default:
                barbecueRice.riceSize = "随便";
        }

        return barbecueRice;
    }
}
