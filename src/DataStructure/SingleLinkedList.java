package DataStructure;

import java.util.ArrayList;
import java.util.Scanner;
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
    }
}
public class SingleLinkedList {
    private int length;//链表长度
    private Node head;//head定义链表
    public SingleLinkedList(){
        length=0;
        head=null;
    }
    //定义链表。单链表中的节点中有数据区域和存放指针的区域，Object可以换成任意的int,string类型

    //插入单向链表数据(方法)
    public Node addHead(int obj){
        Node newHead=new Node(obj);
        if(length==0){
            head=newHead;
        }
        else{
            newHead.next=head;
            head=newHead;
        }
        length++;
        return newHead;
}
//删除单链表的数据，并给返回值信号，需要考虑三个方面：1、链表长度为零 2、整个链表的数据都没有该值 3、万一此值为头节点
    public boolean deleteNode(int obj){
        if(length==0){
            return false;
        }
        Node current=head;
        Node previous=head;
        while(current.data!=obj) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
            if(current==head){
                head=current.next;
                length--;
            }else{
                previous.next=current.next;
                length--;
            }

        return true;
    }
    //查找数据节点
    public Node find(int obj){
        Node current=head;
        int tempSize=length;
        while(tempSize>0){
            if(current.data==obj){
                return current;
            }
            else{
                current=current.next;
            }
            tempSize--;
        }
        return null;
    }
    //打印链表
    public static void printNode(Node head){
        Node current=head;
        while(current!=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
    //主函数调用
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String first=input.nextLine();
        int K=Integer.valueOf(first);
        //两种输入方式，第一种：一个个值的输入回车隔开。第二种：直接输入全部数据 以空格来隔开
//        SingleLinkedList SingleList=new SingleLinkedList();
//        String temp=new String();
        ArrayList<SingleLinkedList> List=new ArrayList<>();
        for(int i=0;i<K;i++){
            SingleLinkedList SingleList=new SingleLinkedList();
            String temp=new String();
            temp=input.nextLine();
            String[] a=temp.split("\\s+");
            for(int j=0;j<a.length;j++){
                SingleList.addHead(Integer.valueOf(a[j]));
            }
            List.add(SingleList);
        }
        //            SingleList.deleteNode(56);
//        Node c =SingleList.find(56);
//            SingleList.printNode(c);
        for(int j=0;j<K;j++) {
            List.get(j).printNode(List.get(j).head);
        }
    }
}
