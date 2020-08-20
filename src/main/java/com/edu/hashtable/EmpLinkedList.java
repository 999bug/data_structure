package com.edu.hashtable;

/**
 * @Date 2020/6/4 20:19
 * @Author by hp
 * @Description 雇员链表
 */
public class EmpLinkedList {
    /**
     * 头指针，执行第一个Emp,因此我们这个链表的head 是直接指向第一个Emp
     * 默认为空
     */
    private Emp head;

    /**
     * 添加雇员到链表
     * 假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
     * 因此我们将该雇员直接加入到本链表的最后即可
     *
     * @param emp 雇员对象
     */
    public void add(Emp emp) {
        //如果是添加的第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //不是第一个雇员,使用辅助指针，定位到最后
        Emp curEmp = head;

        //判断下一个节点是否等于null？
        // 等于null结束循环，不等于空继续后移
        while (curEmp.next != null) {
            //不等于空，继续后移
            curEmp = curEmp.next;
        }

        //退出时直接将emp 加入链表
        curEmp.next = emp;
    }

    /**
     * 遍历链表的雇员信息
     *
     * @param no 表示第几个链表
     */
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "个链表为空");
            return;
        }
        System.out.print("第"+(no+1)+"个链表的信息为");
        //辅助指针
        Emp curEmp = head;
        while(true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            //说明curEmp已经是最后结点
            if(curEmp.next == null) {
                break;
            }
            //后移，遍历
            curEmp = curEmp.next;
        }
        //换行
        System.out.println();
    }

    /**
     * 根据id 查找雇员
     * @param id 雇员id
     * @return 雇员信息
     */
    public Emp findEmpById(int id){
        if (head==null){
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp=head;
        while (true){
            //这时curEmp就指向要查找的雇员
            if (curEmp.id==id){
                break;
            }
            //说明遍历当前链表没有找到该雇员
            if (curEmp.next==null){
                curEmp=null;
                break;
            }
            //向后遍历
            curEmp=curEmp.next;
        }
        return curEmp;
    }

    /**
     * 删除节点
     * @param id
     */
    public void delete(int id){
        if (head==null){
            System.out.println("链表为空");
            return ;
        }
        //辅助指针
        Emp curEmp=head;
        while (true){
            if (head.id==id){
                head=head.next;
                return;
            }
            if (curEmp.next==null){
                break;
            }
            if (curEmp.next.id==id){
                curEmp.next=curEmp.next.next;
            }else {
                System.out.println("找不到需要删除的雇员");
            }
            curEmp=curEmp.next;
        }
    }
}
