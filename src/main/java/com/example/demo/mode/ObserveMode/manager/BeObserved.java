package com.example.demo.mode.ObserveMode.manager;

/**
 * 被观察对象接口
 */
public interface BeObserved {

    // 添加观察对象
    void addListener(Observe observe);

    // 删除观察对象
    void removeListener(Observe observe);

    // 群发提醒
    void notice(String message);

}
