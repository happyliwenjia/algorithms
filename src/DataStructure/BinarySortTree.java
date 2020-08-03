package DataStructure;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class BinarySortTree {
    //定义二叉排序树的每个元素的结构
    class TreeNode{
        int data;
        TreeNode left=null;
        TreeNode Right=null;
        public TreeNode(int data){
            this.data=data;
        }
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        BinarySortTree pro=new BinarySortTree();
        String[] a=s.split("\\s+");
        TreeNode root=null;
        for(int i=0;i<a.length;i++){
            root=pro.insert(root,Integer.valueOf(a[i]));
        }
        pro.BFS(root);
//        pro.DFS(root);
//        int b=input.nextInt();
//        root=pro.deleteBST(root,b);
//        int c=input.nextInt();
//        System.out.println(pro.Search(root,c));

    }
    //插入二叉排序树，一开始就是一个空的
    public TreeNode insert(TreeNode root,int obj){
    TreeNode p=root;
    TreeNode prev=null;
    //一直循环到p为空（p就是待插入节点），prev是p的父节点，目的就是找到prev节点
    while(p!=null) {
        prev = p;
        if (obj < p.data) {
            p = p.left;
        } else if (obj > p.data) {
            p = p.Right;
        } else return root;//说明这个元素本身就是存在的，不用新加
    }
        if(root==null){
            root=new TreeNode(obj);
            return root;
        }
        if(prev.data>obj){
            prev.left=new TreeNode(obj);
        }else{
            prev.Right=new TreeNode(obj);
        }
        return root;
    }

    //删除二叉排序树的元素 一步回溯，一步具体删除步骤，这一步做的是查找到这个元素的位置
    public  TreeNode deleteBST(TreeNode root,int obj){
        TreeNode p=root;
        if(p==null){
            return null;
        }
        if(p.data==obj){
            p=delete(p);
        }else if(p.data>obj){
             p.left=deleteBST(p.left,obj);

        }else{
             p.Right=deleteBST(p.Right,obj);

        }
        return p;
    }
    //删除这个特定节点
    public  TreeNode delete(TreeNode node){
        TreeNode temp=null;
        if(node.left==null){
            node=node.Right;
        }else if(node.Right==null){
            node=node.left;
        }else{
            temp=node;
            TreeNode s=node;
            s=s.left;
            while(s.Right!=null){
                temp=s;
                s=s.Right;
            }
            temp.data=s.data;
            if(temp!=node){
                temp.Right=s.left;
            }else{
                node.left=s.left;
            }
        }
        return node;
    }
    //查询元素
    public  int Search(TreeNode root,int obj){
        TreeNode temp=root;
       int length=0;
       while(temp!=null){
           if(temp.data==obj){
               length++;
               return length;
           }else if(temp.data>obj){
               temp=temp.left;
               length++;
           }else{
               temp=temp.Right;
               length++;
           }
       }
       return 0;
    }
    //深度优先搜索遍历 DFS depth First Search
    public void DFS(TreeNode root){
        if(root==null){
            return;
        }else{
            System.out.print(root.data+" ");
            DFS(root.left);
            DFS(root.Right);
        }
    }
    //广度优先搜索遍历 BFS  Breadth FirstSearch 拿一个放两个
    public void BFS(TreeNode root){
        if(root==null){
            System.out.println("二叉树为空");
            return;
        }
        Queue<TreeNode> e=new LinkedList<TreeNode>();
        e.add(root);
        while(e.size()!=0){
            TreeNode temp=e.remove();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                e.add(temp.left);
            }
            if(temp.Right!=null){
                e.add(temp.Right);
            }
        }
    }
}
