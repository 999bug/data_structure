package com.demo;

/**
 * @Date 2020/10/3 14:45
 * @Author by LSY
 * @Description 饱汉模式单例模式
 */
public class Singleton {
    // 首先，也是先堵死 new Singleton() 这条路
    private Singleton() {
    }
    private static volatile Singleton instance=null;

    public static Singleton getInstance() {
        if (instance==null){
            //加锁
            synchronized (Singleton.class){
                // 这一次判断也是必须的，不然会有并发问题
                if (instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
