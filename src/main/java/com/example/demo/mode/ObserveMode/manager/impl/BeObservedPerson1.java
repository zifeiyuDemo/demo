package com.example.demo.mode.ObserveMode.manager.impl;

import com.example.demo.mode.ObserveMode.manager.BeObserved;
import com.example.demo.mode.ObserveMode.manager.Observe;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * 被观察对象1
 */
public class BeObservedPerson1 implements BeObserved {

    private String name = "嫌疑人1号";

    private List<Observe> observes = Lists.newArrayList();

    // 添加观察对象
    @Override
    public void addListener(Observe observe){
        observes.add(observe);
    }

    // 删除观察对象
    @Override
    public void removeListener(Observe observe){
        observes.remove(observe);
    }

    // 群发提醒
    @Override
    public void notice(String message){
        for (Observe observe : observes){
            observe.detailMsg(name, message);
        }
    }
}
