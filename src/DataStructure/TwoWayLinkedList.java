package DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

//定义双向链表的节点。双向链表的节点应该有3个位置，分别是数据域，next指针域，prev指针域
class TwoNode{
   int data;
   TwoNode next;
   TwoNode prev;
   public TwoNode(int data){
       this.data=data;
   }
}
public class TwoWayLinkedList {
    //定义了整个类都需要的三个变量以及构造函数进行调用类时的初始化
    TwoNode head;
    TwoNode tail;
    int length;
    public  TwoWayLinkedList(){
        TwoNode head=null;
        TwoNode tail=null;
        int length=0;
    }
    //主函数
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        TwoWayLinkedList List=new TwoWayLinkedList();
        String temp=input.nextLine();
        String[] a=temp.split("\\s+");
        for(int i=0;i<a.length;i++) {
            List.insert_Node(Integer.valueOf(a[i]));
        }
        List.print_node(List.head);

    }
    //增加节点,可以加头节点或尾节点，本例中加了头节点
    public void insert_Node(int obj){
        TwoNode newNode=new TwoNode(obj);
        if(length==0){
            head=newNode;
            length++;
        }
        else{
            head.prev=newNode;
            newNode.next=head;
            newNode.prev=null;
            head=newNode;
            length++;
        }
    }
    //删除节点。同增加节点一样，可以删除头节点或是尾节点，本例中删除头节点
    public TwoNode delete_head(){
        if(length==0){return null;}
        else{
            head=head.next;
            head.prev=null;
            length--;
            return head;
        }
    }
    //删除指定节点
    public TwoNode delete_Node(int obj){
        TwoNode current=head;
        if(length==0){
            return null;
        }
        else{
            while(current.data!=obj){
                if(current==tail){
                    return null;
                }else{
                    current=current.next;
                }
            }
            if(current==head){
                head=head.next;
                head.prev=null;
            }else if(current==tail){
                tail=tail.prev;
                tail.next=null;
            }else {
                current.prev.next = current.next;
                current.next = current.prev;
            }
            length--;
            return head;
        }
    }
    //打印链表
    public void print_node(TwoNode head){
        TwoNode temp=head;
        if(length==0){
            System.out.println("此链表为空");
        }
        else{
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
}
