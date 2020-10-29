package com.javacore.v2Ch01;

/**
 * @Date 2020/10/15 8:59
 * @Author by LSY
 * @Description
 */
public class StringDemo {
    @Override
    public String toString() {
        return "err"+this;
    }

    public static void main(String[] args) {
        StringDemo demo=new StringDemo();
        System.out.println(demo);
    }
}
