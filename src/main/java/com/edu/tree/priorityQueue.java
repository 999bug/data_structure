package com.edu.tree;

import java.util.Arrays;

/**
 * 优先队列
 */
public class priorityQueue {
    private int[] array;
    private int size;
    private int intkey=0;

    public priorityQueue() {
        //队列初始长度为32
        array = new int[32];
    }

    /**
     * 入队
     * @param key 入队元素
     */
    public void enQueue(int key){
        if(size>=array.length)
            resize();
        array[size++]=key;
        upAdjust();
    }

    /**
     * 出队
     * @return  出队元素
     */
    public int deQueue() throws Exception {
        if (size<=0)
            throw new Exception("队列为空");
        int head=array[0];
        array[0]=array[--size];
        downAdjust();
        return head;
    }

    /**
     * 上浮调整
     */
    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        //temp 保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        //最大二叉堆
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex]=array[parentIndex];
            childIndex=parentIndex;
            parentIndex=(parentIndex-1)/2;
        }
        array[childIndex]=temp;
    }

    /**
     * 下沉调整
     */
    private void downAdjust(){
        int parentIndex=0;
        int temp = array[parentIndex];
        int childIndex=1;
        while(childIndex<size){
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if(childIndex+1<size&&array[childIndex+1]>array[childIndex]){
                childIndex++;
            }
            //如果父节点大于任何一个孩子的值，直接跳出
            if (temp>=array[childIndex]){
                break;
            }
            //无需真正交换，单向赋值即可
            array[parentIndex]=array[childIndex];
            parentIndex=childIndex;
            childIndex=2*childIndex+1;
        }
        array[parentIndex]=temp;
    }

    /**
     * 队列扩容
     */
    private void resize(){
        int newsize =this.size*2;
        this.array= Arrays.copyOf(this.array,newsize);
    }


    /**
     * 创建二叉堆
     */
    private   void buildHeap() {
        //从最后一个非叶子子节点开始，依次做下沉调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            upAdjust();
        }
    }

    /**
     * 输出堆
     */
    private void showHeap(){
        buildHeap();
            System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) throws Exception {
        priorityQueue priorityQueue=new priorityQueue();
        int []array=new int[]{1,3,2,6,5,7,8,9,10};
        for (int i : array) {
            priorityQueue.enQueue(i);
        }
     priorityQueue.showHeap();
      System.out.println("出队元素"+priorityQueue.deQueue());
        priorityQueue.showHeap();
      System.out.println("出队元素"+priorityQueue.deQueue());
        priorityQueue.showHeap();
    }
}
