package class03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Moment_Sky
 * Date: 2022-11-11
 * Time: 下午10:38
 */
//反转链表
public class Code01_ReverseList {
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            value = data;
        }
    }
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int data) {
            value = data;
        }
    }
    //反转单链表
    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    //反转双链表
    public static DoubleNode  reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    //以下为对数器  当然可以用LinkList类来实现  这里演示一下用ArrayList容器方式

    //测试单链表 与  ArrayList容器得到的值是否相同
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    //测试双链表 与  ArrayList容器得到的值是否相同
    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        //为什么要来顺序加逆序来核对两遍
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.last;
        }
        return true;
    }

    //把单链表的值按顺序存入可变数组ArrayList中
    public static List<Integer> getLinkedListOriginOrder(Node head){
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    //把双链表的值按顺序存入可变数组ArrayList中
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    //生产随机单链表
    public static Node generateRandomLinkedList(int len, int value){
        //链表长度 0 ~ 51 左闭右开
        int size = (int)(Math.random()*(len+1));
        if(size == 0){
            return null;
        }
        size--;//表示链表第一个长度给了head 头结点
        Node head = new Node((int)(Math.random()*(value + 1)));
        Node pre = head;
        while(size != 0){
            Node cur = new Node((int)(Math.random()*(value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    //生成随机双链表
    public static DoubleNode generateRandomDoubleList(int len, int value){
        int size = (int)(Math.random()*(len+1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int)(Math.random()*(value + 1)));
        DoubleNode pre = head;
        while (size != 0){
            DoubleNode cur = new DoubleNode((int)(Math.random()*(value + 1)));
            pre.next = cur;
            cur.last = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for(int i=0;i<testTime;i++){
            //生产随机单链表
            Node node1 = generateRandomLinkedList(len,value);
            List<Integer> list1 = getLinkedListOriginOrder(node1);
            node1 = reverseLinkedList(node1);
            if (!checkLinkedListReverse(list1, node1)) {
                System.out.println("Oops1!");
            }
            //生成随机双链表
            DoubleNode node3 = generateRandomDoubleList(len, value);
            List<Integer> list3 = getDoubleListOriginOrder(node3);
            node3 = reverseDoubleList(node3);
            if (!checkDoubleListReverse(list3, node3)) {
                System.out.println("Oops3!");
            }

        }
        System.out.println("test finish!");
    }


}
