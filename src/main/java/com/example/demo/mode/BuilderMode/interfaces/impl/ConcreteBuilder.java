package com.example.demo.mode.BuilderMode.interfaces.impl;

import com.example.demo.mode.BuilderMode.interfaces.Builder;
import com.example.demo.mode.BuilderMode.interfaces.Product1;

/**
 * 具体构建
 */
public class ConcreteBuilder implements Builder {

    private Product1 product1;

    public ConcreteBuilder(){
        product1 = new Product1();
    }

    @Override
    public void buildBasic(){
        System.out.println("底层部门构建");
    }

    @Override
    public void buildWalls(){
        System.out.println("中间部件加工over");
    }

    @Override
    public void buildFed(){
        System.out.println("最终部件加工结束");
    }

    public Product1 getResult(){
        return product1;
    }
}
