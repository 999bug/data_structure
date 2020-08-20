package com.edu.singleLinkedListdemo;

import java.util.Stack;

public class Singlelinkedlist {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "松江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "赵四", "亚洲舞王");
        HeroNode hero3 = new HeroNode(3, "武松", "打虎");
        HeroNode hero4 = new HeroNode(4, "潘长江", "王");
        HeroNode hero5 = new HeroNode(5, "潘长江", "王");
        HeroNode hero6 = new HeroNode(6, "潘长江", "王");
        HeroNode hero7 = new HeroNode(7, "潘长江", "王");
        HeroNode hero8 = new HeroNode(8, "潘长江", "王");
        HeroNode hero9 = new HeroNode(9, "潘长江", "王");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero5);
        singleLinkedList.add(hero7);


        singleLinkedList2.add(hero2);
        singleLinkedList2.add(hero4);
        singleLinkedList2.add(hero6);
        singleLinkedList2.add(hero8);
        singleLinkedList2.add(hero9);

        HeroNode heroNode = hebingList(singleLinkedList.getHead(), singleLinkedList2.getHead());
        SingleLinkedList list = new SingleLinkedList();
        list.list(heroNode);
//        HeroNode tt=heroNode.next;
//        while (tt!= null) {
//            System.out.print(tt.next.no + " ");
//            tt = tt.next;
//        }






       /* singleLinkedList.addByorder(hero2);
        singleLinkedList.addByorder(hero4);
        //  singleLinkedList.addByorder(hero3);
        singleLinkedList.addByorder(hero3);
        singleLinkedList.addByorder(hero1);

        singleLinkedList.list();
        System.out.println("**********");
        HeroNode newHero = new HeroNode(1, "王五", "小王八");
        singleLinkedList.update(newHero);
        singleLinkedList.list();
        System.out.println("#########");
        singleLinkedList.del(1);
        singleLinkedList.list();

        //求单链表中有效节点的个数
        System.out.println("有效节点的个数" + getLength(singleLinkedList.getHead()));

        //查找链表中的倒数第k个节点
        int index = 3;
        HeroNode temp = findLastIndexnode(singleLinkedList.getHead(), index);
        System.out.printf("倒数第%d个节点是", index);
        System.out.println(temp);

        //实现单链表的反转
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("**************");
        //实现单链表的反转输出
        reservsePrint(singleLinkedList.getHead());*/

        //合并两个链表


    }

    //定义SingleLinkedList 管理我们的英雄
    static class SingleLinkedList {
        //先初始化一个头节点，头节点不要动，不存放具体的数据
        private HeroNode head = new HeroNode(0, "", "");

        //返回头节点
        public HeroNode getHead() {
            return head;
        }

        //添加节点到单向链表
        //思路，当不考虑编号顺序时
        //1.找到当前链表的最后节点
        //2.将最后这个节点的next 指向新的节点
        public void add(HeroNode heroNode) {
            //因为head节点不能动，因此我们需要一个辅助变量遍历temp
            HeroNode temp = head;
            //遍历链表，找到最后
            while (true) {
                //找到链表最后
                if (temp.next == null)
                    break;
                //如果没有找到最后，就将temp后移
                temp = temp.next;
            }
            //当退出while循环时，temp就指向了链表的最后
            //将最后这个节点的next指向新的节点
            temp.next = heroNode;
        }

        //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
        // (如果有这个排名，则添加失败，并给出提示)
        public void addByorder(HeroNode heroNode) {
            HeroNode temp = head;
            Boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no > heroNode.no) {
                    break;
                }
                if (temp.next.no == heroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                System.out.printf("%d编号已经存在" + "\n", heroNode.no);
            } else {
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }

        //修改英雄的名字和昵称，不改变编号
        public void update(HeroNode newHeroNode) {

            if (head.next == null) {
                System.out.println("队列为空");
                return;
            }
            boolean flag = false;
            HeroNode temp = head.next;

            while (true) {
                if (temp == null) {
                    break;
                }
                if (temp.no == newHeroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //根据flag，判断是否找到需要修改的节点
            if (flag) {
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;
            } else {
                System.out.printf("没有找到编号%d的节点不能修改\n", newHeroNode.no);
            }
        }

        //删除节点
        //思路
        //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
        //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
        public void del(int no) {
            HeroNode temp = head;
            boolean flag = false;

            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no == no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.next = temp.next.next;
                //  temp.next=null;
            } else {
                System.out.printf("没有此选项%d的编号", no);
            }
        }

        //显示链表【遍历】
        public void list(HeroNode heroNode) {
            //判断链表是否为空
            if (heroNode.next == null) {
                System.out.println("链表为空");
                return;
            }
            //因为头节点，不能动，因此我们需要一个辅助变量来遍历
            HeroNode temp = heroNode.next.next;
            while (true) {
                //判断是否到链表最后
                if (temp == null) {
                    break;
                }

                System.out.println(temp);
                //将temp后移
                temp = temp.next;
            }

        }
    }

    //合并两个有序的单链表
    public static HeroNode hebingList(HeroNode h1, HeroNode h2) {
        if (h1 == null && h2 == null) {
            return h1;
        }
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;

        HeroNode newHeroNode=null;
        if (h1.no < h2.no) {
            newHeroNode = h1;
            newHeroNode.next = hebingList(h1.next, h2);
        } else {
            newHeroNode = h2;
            newHeroNode.next = hebingList(h1, h2.next);
        }
        return newHeroNode;


    }


    //单链表的反转打印输出
    public static void reservsePrint(HeroNode head) {
        if (head.next == null)
            return;//空链表，不能打印
        //创建一个栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    //单链表的反转
    public static void reverseList(HeroNode head) {
        //如果当前列表为空或只有一个则无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode temp = head.next;
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode next = null;
        while (temp != null) {
            next = temp.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            temp.next = reverseHead.next;//将temp的下一个节点指向新的链表的最前端
            reverseHead.next = temp;//将temp 连接到新的链表上
            temp = next;//让temp后移
        }
        head.next = reverseHead.next;//将head.next指向reservseHead.next 实现单链表的反转

    }

    //方法：获取到单链表的节点的个数（如果是带头结点则不统计带头节点）

    /***
     *
     * @param head
     * @return 返回单链表的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null)
            return 0;
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //查找单链表中的倒数第k个节点
    public static HeroNode findLastIndexnode(HeroNode head, int index) {
        //判断如果链表为空，返回空
        if (head.next == null) {
            return null;
        }
        //第一次遍历得到链表的长度（节点个数）
        int size = getLength(head);
        //做一个index校验
        if (index <= 0 && index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;

    }

    //定义HeroNode,每个HeroNode对象就是一个节点
    static class HeroNode {
        public int no;
        public String name;
        public String nickname;
        public HeroNode next;//指向下一个节点
        //构造器


        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
}
