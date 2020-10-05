package com.demo;

/**
 * @Date 2020/10/3 14:45
 * @Author by LSY
 * @Description 嵌套类 单例模式
 */
public class Singleton12 {
    private Singleton12() {
    }

    private static class Holder {
        private static Singleton12 instance = new Singleton12();
    }

    public static Singleton12 getInstance() {
        return Holder.instance;
    }
}
