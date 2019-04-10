package com.example.demo.mode.SimpleFactory.factory;

/**
 * 总店
 */

public interface MainRestaurantFactory {

  static <T extends MainRestaurantFactory> T createFactory(Class c){
      MainRestaurantFactory factory = null;
      try{
          factory = (MainRestaurantFactory)Class.forName(c.getName()).newInstance();
      } catch (Exception e) {
          System.out.println("获取工厂失败:{}"+e);
      }
      System.out.println("店铺查找成功");
      return (T) factory;
  }

}
