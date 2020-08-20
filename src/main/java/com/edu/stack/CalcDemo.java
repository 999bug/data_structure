package com.edu.stack;

/**
 * @Date 2020/4/9 12:05
 * @Author hp
 * 利用中缀表达式实现计算器
 */
public class CalcDemo {
    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
        //创建两个栈，数栈，字符栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        //定义相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch ; //将每次扫描得到char保存到ch
        String keepNum =""; //用于拼接 多位数
        //开始while循环的扫描expression
        while (true) {
            //依次得到expression的每个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，做相应处理
            if (operStack.isOper(ch)) {//如果是字符
                if (!operStack.isEmpty()) {//非空
                    //如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数,
                    //在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <=operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算结果进数栈
                        numStack.push(res);
                        //然后将当前的运算符进入符号栈
                        operStack.push(ch);
                    }
                } else {//为空直接入符号栈
                    operStack.push(ch);
                }
            } else {//是数字，
                keepNum += ch;

                //如果ch已经是expression的最后一位，则直接入数字栈
                if (index==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }
                else{
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意是看后一位，不是index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum=""; //keepNum清空
                    }
                }
            }
            //让index + 1, 并判断是否扫描到expression最后.
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
        while (true){
            //如果符号栈为空，说明只有一个数字在数字栈
            if (operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.cal(num1,num2,oper);
            numStack.push(res);//入栈
        }
        int res2=numStack.pop();
        System.out.printf("表达式 %s = %d", expression, res2);

    }
}
