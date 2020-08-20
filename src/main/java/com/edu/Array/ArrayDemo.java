package com.edu.Array;

public class ArrayDemo {
    private int[] array;
    private int size;//数组中元素的总个数

    public ArrayDemo(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 在数组中间插入元素
     *
     * @param element 插入的元素
     * @param index   插入的位置
     */
    public void insert(int element, int index) {
        //判断是否超出范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        //腾出的位置放入新的元素
        array[index] = element;
        size++;
    }

    /**
     * 在数组中间插入数组，当数组满时自动扩容
     *
     * @param element 插入的元素
     * @param index   插入的位置
     */
    public void insertPro(int element, int index) {
        if (index < 0 || index > size) {
            throw  new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        if(size>=array.length){
            resize();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    /**
     * 删除数组元素
     * @param index 指定删除的位置（下标从0开始）
     * @return
     */
    public int delete(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("超出数组实际元素的范围");
        }
        int deleteElement=array[index];
        //从左向右循环，将元素逐个向左移动
        for (int i = index; i <size-1 ; i++) {
            array[i]=array[i+1];
        }
        size--;
        return deleteElement;//返回被删除的元素
    }

    /**
     * 扩容数组
     */
    public void resize() {
        int[] arrayNew=new int[array.length*2];
        System.arraycopy(array,0,arrayNew,0,array.length);
        array=arrayNew;
    }

    /**
     * 输出数组
     */
    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        ArrayDemo myArray = new ArrayDemo(10);
        //不考虑扩容的添加
//        myArray.insert(5, 0);
//        myArray.insert(15, 1);
//        myArray.insert(56, 2);
//        myArray.insert(3, 2);

        //考虑扩容的添加
        myArray.insertPro(24,0);
        myArray.insertPro(34,1);
        myArray.insertPro(44,2);
        myArray.insertPro(54,3);
        myArray.insertPro(64,4);
        myArray.insertPro(666,5);
        myArray.output();

        System.out.println("*********");
        //删除指定元素
        myArray.delete(5);
        myArray.output();
    }
}
