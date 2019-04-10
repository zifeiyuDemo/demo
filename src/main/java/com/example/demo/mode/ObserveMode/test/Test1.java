package com.example.demo.mode.ObserveMode.test;

import com.example.demo.mode.ObserveMode.manager.BeObserved;
import com.example.demo.mode.ObserveMode.manager.Observe;
import com.example.demo.mode.ObserveMode.manager.impl.BeObservedPerson1;
import com.example.demo.mode.ObserveMode.manager.impl.ObserverFirst;
import com.example.demo.mode.ObserveMode.manager.impl.ObserverSecond;

/**
 *适用场景：
 *  当一个抽象模型有2个方面，其中一方面依赖另一方面
 *  当对一个对象改变需要改变其他对象，而不知道具体由多少对象有待改变。
 *  当一个对象改变必须通知其他对象，而又不能假定对象，
 */
public class Test1 {

    //
    public static void main(String[] argas){
        BeObserved person = new BeObservedPerson1();

        Observe one = new ObserverFirst();
        Observe teo = new ObserverSecond();

        person.addListener(one);
        person.addListener(teo);

        person.notice("进行提示信息啦");
    }

}
