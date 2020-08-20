package com.edu.stack;

/**
 * @Date 2020/4/10 9:20
 * @Author hp
 * 运算符优先级
 */
public class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    /**
     * @param operation 字符
     * @return 对应的优先级数字
     */
    public int getValue(String operation){
        int c = operation.toCharArray()[0];
        int res=0;
        switch (c){
            case '+':
                res=ADD;
                break;
            case '-':
                res=SUB;
                break;
            case '*':
                res=MUL;
                break;
            case '/':
                res=DIV;
                break;

        }
        return res;
    }
}
