package com.mj;

import com.mj.model.Person;

/**
 * @Date 2020/9/9 10:17
 * @Author by LiShiYan
 * @Descaption
 */
public class Test {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};
    int num = 10;
    Person person = new Person(12, 44F, "jack");

    static void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'b';
    }

    static void change2(int num, char[] ch) {
        num = 2;
        ch[0] = 'b';
    }

    static void change3(Person num, char[] ch) {
        num.setAge(18);
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        Test test = new Test();
        change(test.str,test.ch);
       // change2(test.num, test.ch);
        //change3(test.person, test.ch);
        System.out.println(test.str);
        System.out.println(test.ch);
    }
}
