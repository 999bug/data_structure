package com.interview;

/**
 * @Date 2020/9/28 18:16
 * @Author by LSY
 * @Description 面试题
 */
public class TT {
    public static void main(String[] args) {
        StringBuffer a =new StringBuffer("A");
        StringBuffer b =new StringBuffer("B");
        operate(a,b);

        System.out.println(a.hashCode());
        System.out.println(a+"," + b);
    }

    private static void operate(StringBuffer a, StringBuffer b) {

        a.append(b);
        System.out.println(a.hashCode());
      StringBuffer cc=  a;
        cc=b;

    }
}
