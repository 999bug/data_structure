package com.edu.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Date 2020/4/15 20:54
 * @Author 17接计一 李石岩 201743710111
 */
public class CheckOperator {
    public static void main(String[] args) {
        String str = "{}[]()";
        //将中缀表达式转换为list集合
        List<String> list = transformToList(str);
        System.out.println(list.toString());
        //判断集合里的字符是否格式正确
        Boolean operator = isOperator(list);
        System.out.println(operator);
    }

    /**
     * 检验输入字符是否正确
     *
     * @param list
     * @return
     */
    public static Boolean isOperator(List<String> list) {
        boolean flag = false;
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            switch (s) {
                case "(":
                    stack.push(s);
                    continue;
                case "[":
                    stack.push(s);
                    continue;
                case "{":
                    stack.push(s);
                    continue;
                case ")":
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        continue;
                    }
                    //运算符不匹配返回false
                    return false;
                case "]":
                    if (stack.peek().equals("[")) {
                        stack.pop();
                        continue;
                    }
                    //运算符不匹配返回false
                    return false;
                case "}":
                    if (stack.peek().equals("{")) {
                        stack.pop();
                        continue;
                    }
                    //运算符不匹配返回false
                    return false;
                default:
                    throw new RuntimeException("运算符错误");
            }
        }
        //如果栈为空说明字符完全匹配，返回true
        if (stack.isEmpty()) {
            flag = true;
        }

        return flag;
    }


    /**
     * 将 中缀表达式转成List集合存储
     *
     * @param expr
     * @return
     */
    public static List<String> transformToList(String expr) {
        List<String> list = new ArrayList<String>();
        //这是一个指针用于遍历expr字符
        int i = 0;
        String strNum;//用于多位数拼接
        char c;//每遍历一个字符，就放入c
        do {
            //如果c不是数字，放入list集合
            if ((c = expr.charAt(i)) < 48 || (c = expr.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else { //c是数字，考虑多位数
                strNum = "";
                while (i < expr.length() && (c = expr.charAt(i)) >= 48 && (c = expr.charAt(i)) <= 57) {
                    //拼接字符串
                    strNum += c;
                    i++;
                }
                list.add(strNum);
            }
        } while (i < expr.length());

        return list;
    }
}
