package com.edu.hashtable;

/**
 * @Date 2020/6/4 20:39
 * @Author by hp
 * @Description 散列表
 */
public class HashTable {
    /**
     * 哈希数组
     */
    private EmpLinkedList[] empLinkedLists;
    /**
     * 初始大小
     */
    private Integer size;

    public HashTable(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        //初始化链表，防止空指针异常
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     *
     * @param emp 雇员
     */
    public void add(Emp emp) {
        //根绝散列函数确定到哪条链表查找
        int i = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedLists[i].add(emp);
    }

    /**
     * 遍历所有的链表，遍历hashTable
     */
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    /**
     * 编写散列函数，使用取模法
     * @param id 数值
     * @return 散列值
     */
    private int hashFun(int id) {
        return id % size;
    }

    /**
     * 根据id查找雇员信息
     * @param id 雇员id
     */
    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int i = hashFun(id);
        Emp emp = empLinkedLists[i].findEmpById(id);
        if (emp!=null){
            //下标从0开始，所以要＋1
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (i + 1), id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    /**
     * 删除雇员信息
     * @param id 雇员id
     */
    public void delete(int id){
        int i = hashFun(id);
        empLinkedLists[i].delete(id);
    }
}
