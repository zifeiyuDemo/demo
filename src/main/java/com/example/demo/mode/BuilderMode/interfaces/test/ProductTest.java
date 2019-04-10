package com.example.demo.mode.BuilderMode.interfaces.test;

import com.example.demo.mode.BuilderMode.interfaces.Director;
import com.example.demo.mode.BuilderMode.interfaces.Product1;
import com.example.demo.mode.BuilderMode.interfaces.impl.ConcreteBuilder;

/**
 * 测试类
 */
public class ProductTest {

    public static void main(String[] args){
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director();
        Product1 product1 = director.constructProduct(builder);

        product1 = director.constrictProduct3(builder);

        product1 = director.constrictProduct2(builder);

    }
}
