package com.edu.stack;

/**
 * @Date 2020/4/9 10:46
 * @Author hp
 */
public class ArrayStack {

    private Integer maxSize;//栈的大小
    private Integer top = -1; //栈顶元素
    private Integer[] stack;// 数组，数组模拟栈，数据就放在该数组

    public ArrayStack(Integer maxSize) {
        this.maxSize = maxSize;
        stack = new Integer[maxSize];
    }

    //可以返回当前栈顶的值, 但是不是真正的pop
    public int peek() {
        return stack[top];
    }

    //栈是否满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //判断栈是否满
        if (isFull()) {
            throw new RuntimeException("栈以满");
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        //判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int rtValue = stack[top];
        top--;
        return rtValue;
    }

    //显示栈里存在的元素
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    /**
     * 返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
     * 数字越大，则优先级就越高
     * @param oper
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        }else {
            return -1; // 假定目前的表达式只有 +, - , * , /
        }
    }

    /**
     * 判断是不是一个运算符
     * @param val
     * @return
     */
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

    /**
     * 计算方法
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1,int num2,int oper){
        int res=0;
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num1/num2;
                break;
                default:
                    break;
        }
        return res;
    }
}
