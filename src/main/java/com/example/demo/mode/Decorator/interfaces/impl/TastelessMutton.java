package com.example.demo.mode.Decorator.interfaces.impl;

import com.example.demo.mode.Decorator.interfaces.MuttonShashlik;

/**
 * 原味羊肉串
 */
public class TastelessMutton implements MuttonShashlik {
    // 切肉
    @Override
    public void cutMutton(){
        System.out.println("开始切羊肉，准备穿串了");
    }

    // 串串
    @Override
    public void assembleMutton(){
        System.out.println("正在穿串");
    }

    // 调味
    @Override
    public void setFlavor(){
        System.out.println("调味");
    }

    @Override
    public void process(){
        cutMutton();
        assembleMutton();
        setFlavor();
        System.out.println("开始烤制...");
    }
}
