package com.example.demo.mode.BuilderMode.interfaces;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.mode.BuilderMode.interfaces.impl.ConcreteBuilder;

/**
 * 用于最后器械的组装
 */
public class Director {

    public Product1 constructProduct(ConcreteBuilder builder){
        System.out.println("奢华高配版");
        builder.buildBasic();
        builder.buildWalls();
        builder.buildFed();
        return builder.getResult();
    }

    public Product1 constrictProduct2(ConcreteBuilder builder){
        System.out.println("简装低配版");
        builder.buildBasic();
        return builder.getResult();
    }

    public Product1 constrictProduct3(ConcreteBuilder builder){
        System.out.println("运动中配版");
        builder.buildBasic();
        builder.buildWalls();
        return builder.getResult();
    }
}
