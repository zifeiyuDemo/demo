package com.example.demo.mode.Decorator.test;

import com.example.demo.mode.Decorator.interfaces.MuttonShashlik;
import com.example.demo.mode.Decorator.interfaces.SaltyFlavor;
import com.example.demo.mode.Decorator.interfaces.SpicyFlavor;
import com.example.demo.mode.Decorator.interfaces.impl.TastelessMutton;

/**
 * 现烤羊肉串
 */
public class Test1 {

    public static void main(String[] args){
        MuttonShashlik mutton = new TastelessMutton();

        mutton = new SaltyFlavor(mutton);
        mutton = new SpicyFlavor(mutton);

        mutton.process();

        System.out.println("吃吧。。。");
    }
}
