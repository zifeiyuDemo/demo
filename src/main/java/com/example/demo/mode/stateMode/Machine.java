package com.example.demo.mode.stateMode;

import com.example.demo.mode.stateMode.manager.State;

/**
 * 状态模式
 优点：
 1）面向接口式编程，将实现细节巧妙封装在各个不同的状态类中，状态转换交给状态类自己去实现，外部无需关心；
 2）将由大量业务、大量逻辑判断的代码去除，状态类内部通过状态的转换实现相关逻辑，代码可读性更好；
 缺点：
 1）增加新的状态时会增加状态类，而且在增加新的状态类之后，环境类需要做相应的修改，不太符合开闭原则;
 */
public class Machine {

    private State state;

    public Machine(){
        // 构造方法初始化 一个礼物机器

    }

}
