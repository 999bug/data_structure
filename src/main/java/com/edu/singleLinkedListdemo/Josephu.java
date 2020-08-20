package com.edu.singleLinkedListdemo;

/**
 * @Date 2020/4/8 19:43
 * @Author hp
 * 约瑟夫问题
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingLinkedList scl=new CircleSingLinkedList();
        scl.addBoy(5);
       // scl.show();
        scl.countBody(1,2 ,5);
    }
    /**
     * 创建一个环形的单向链表
     */
    static class CircleSingLinkedList{
        //创建第一个first节点，当前没有编号
       private Boy first=null;

       //添加小孩节点，构成一个环形的链表
        public void addBoy(int nums){
            if (nums<1){
                throw new RuntimeException("nums值不正确");
            }
            Boy curBoy =null;//辅助指针，帮助构建环形链表
            for (int i = 1; i <=nums ; i++) {
                Boy boy=new Boy(i);
                //如果是第一个小孩
                if (i==1){
                    first=boy;
                    first.setNext(first);//构成环
                    curBoy=first;// 让curBoy指向第一个小孩
                }
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }

        /**
         *
         * @param startNum 从几开始数
         * @param countNum 数几下
         * @param nums 一开始有多少孩子在圈中
         */
        public void countBody(int startNum,int countNum,int nums){
            if(first==null||startNum<1||startNum>nums){
                System.out.println("ERROR");
                return;
            }
            // 创建要给辅助指针,帮助完成小孩出圈
            Boy helper=first;
            // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
            while(true){
                if (helper.getNext()==first){
                    break;
                }
                helper=helper.getNext();
            }
            //小孩报数前，先让 first 和  helper 移动 k - 1次
            for (int i = 0; i <startNum-1 ; i++) {
                first=first.getNext();
                helper=helper.next;
            }
            //当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
            //这里是一个循环操作，知道圈中只有一个节点
            while(true){
                if (first==helper){//说明圈中只有一个节点
                    System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
                    return;
                }
                for (int i = 0; i <countNum-1 ; i++) {
                    first=first.getNext();
                    helper=helper.getNext();
                }
                //这时first指向的节点，就是要出圈的小孩节点
                System.out.printf("小孩%d出圈\n", first.getNo());
                //这时将first指向的小孩节点出圈
                first=first.next;
                helper.next=first;
            }
        }

        /**
         * 遍历当前的环形链表
         */
        public  void show(){
            if (first==null){
                throw new RuntimeException("No body！");
            }
            //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
            Boy curBoy = first;
            while(true){
                System.out.printf("小孩的编号为：%d \n",curBoy.getNo());
                //说明遍历完毕
                if (curBoy.getNext()==first){
                    break;
                }
                curBoy=curBoy.getNext();//curBoy后移
            }
        }

    }
    /**
     * 创建一个Boy类，表示一个节点
     */
    static class Boy{
        private int no; //编号
        private Boy next;//指向下一个节点
        public Boy(int ano){
            this.no=ano;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Boy getNext() {
            return next;
        }

        public void setNext(Boy next) {
            this.next = next;
        }
    }
}
