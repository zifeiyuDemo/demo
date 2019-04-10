package com.example.demo.example;

import com.example.demo.model.User;

import java.util.*;

public class Demo1 {

    public static void main(String[] args){
        Demo1 demo1 = new Demo1();
        demo1.demo();
    }

    // 已知 HashMap<Integer, String> user 集合， user中含有 name age ，实现一个根据 age排序
    public void demo(){
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1, new User("张三", 20));
        users.put(2, new User("李四", 26));
        users.put(3, new User("王五", 18));

        HashMap<Integer, User> newMap = sortHashMap(users);

        System.out.println(newMap);

    }

    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> users){
        // 首先获取set entry
        Set<Map.Entry<Integer, User>> entitySet = users.entrySet();
        // 转换为list
        List<Map.Entry<Integer, User>> userList = new ArrayList<>(entitySet);

        Collections.sort(userList, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o1.getValue().getAge() - o2.getValue().getAge()>0?-1:1;
            }
        });

        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();

        for(Map.Entry<Integer, User> entry : userList){
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }
}
