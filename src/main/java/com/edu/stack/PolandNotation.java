package com.edu.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Date 2020/4/9 21:20
 * @Author hp
 * 逆波兰计算器
 */
public class PolandNotation {

    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        //将表达式存入list集合
        List<String> middleList = transformToList(expression);
        //判断表达式是否正确
        Boolean goodExpression = isGoodExpression(middleList);
        if (goodExpression){
            List<String> suffixList = transformToSuffixExprList(middleList);
            int calc = calc(suffixList);
            System.out.println(calc);
        }else {
            throw new RuntimeException("表达式错误");
        }

    }

    /**
     * 判断表达式是否正确
     *
     * @param list
     */
    public static Boolean isGoodExpression(List<String> list) {
        boolean flag = false;
        Stack stack = new Stack();
        for (String s : list) {
            //如果为（ 则进栈
            if (s.equals("(")) {
                stack.push(s);
            } //如果为右括号，判断栈是否为空，如果为空则代表运算符错误
            else if (s.equals(")")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }else{
                    return false;
                }
            }
            else {
                continue;
            }
        }
        //遍历结束，如果栈为空则运算符正确
        if (stack.isEmpty()){
            flag=true;
        }
        return flag;
    }

    /**
     * 将中缀表达式list集合转换为后缀表达式list集合
     *
     * @return 后缀表达式list集合
     */
    public static List<String> transformToSuffixExprList(List<String> ls) {
        Operation operation = new Operation();
        //定义符号栈
        Stack<String> s1 = new Stack<String>();
        //定义存放中间数值的list集合
        List<String> s2 = new ArrayList<>();

        //遍历ls
        for (String item : ls) {
            //如果是数字加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    //依次弹出s1栈顶元素直到为"("时
                    s2.add(s1.pop());
                }
                //!!! 将 ( 弹出 s1栈， 消除小括号
                s1.pop();
            } else {
                //item优先级比栈顶优先级低，且栈不为空
                while (s1.size() != 0 && operation.getValue(s1.peek()) >= operation.getValue(item)) {
                    //将s1栈顶的运算符弹出并加入到s2中
                    s2.add(s1.pop());
                }
                //栈为空直接将运算符压入s1
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        //注意因为是存放到List, 因此按顺序输出就是对应的后缀表达式对应的List
        return s2;
    }

    /**
     * 将 中缀表达式转成List集合存储
     *
     * @param expr
     * @return
     */
    public static List<String> transformToList(String expr) {
        List<String> list = new ArrayList<String>();
        int i = 0;  //这是一个指针用于遍历expr字符
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
                    strNum += c; //拼接字符串
                    i++;
                }
                list.add(strNum);
            }
        } while (i < expr.length());

        return list;
    }

    /**
     * 计算表达式的值
     *
     * @param se 例如: (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 - , 针对后缀表达式求值步骤如下:
     *           1. 从左至右扫描，将3和4压入堆栈；
     *           2. 遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
     *           3. 将5入栈；
     *           4. 接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
     *           5. 将6入栈；
     *           最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static int calc(List<String> se) {
        // 创建给栈, 只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        // 遍历 se
        for (String item : se) {
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop出两个数，并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res 入栈
                stack.push("" + res);
            }

        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }

}
