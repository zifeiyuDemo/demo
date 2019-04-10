package com.example.demo.mode.BuilderMode.interfaces;

/**
 * 用于获取各部件创建
 */
public interface Builder {

    /**
     * 部门1
     */
    void buildBasic();

    /**
     * 部件2
     */
    void buildWalls();

    /**
     * 部件3
     */
    void buildFed();

    /**
     * 最终结果
     * @return
     */
    Product1 getResult();

}
