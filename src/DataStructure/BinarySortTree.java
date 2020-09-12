package DataStructure;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class BinarySortTree {
    //定义二叉排序树的每个元素的结构
    class TreeNode{
        int val;
        TreeNode left=null;
        TreeNode right=null;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public static void main(String[] args){
//        Scanner input=new Scanner(System.in);
//        String s=input.nextLine();
        BinarySortTree pro=new BinarySortTree();
//        String[] a=s.split("\\s+");
        TreeNode root=null;
//        for(int i=0;i<a.length;i++){
//            root=pro.insert(root,Integer.valueOf(a[i]));
//        }
        int[] nums={5,9,12,15,-1,17,18,1,2,-1,3};
        root=pro.DFSCreateTree(nums);
        pro.DFS(root);
//        pro.BFS(root);
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
        if (obj < p.val) {
            p = p.left;
        } else if (obj > p.val) {
            p = p.right;
        } else return root;//说明这个元素本身就是存在的，不用新加
    }
        if(root==null){
            root=new TreeNode(obj);
            return root;
        }
        if(prev.val>obj){
            prev.left=new TreeNode(obj);
        }else{
            prev.right=new TreeNode(obj);
        }
        return root;
    }
    //删除二叉排序树的元素 一步回溯，一步具体删除步骤，这一步做的是查找到这个元素的位置
    public  TreeNode deleteBST(TreeNode root,int obj){
        TreeNode p=root;
        if(p==null){
            return null;
        }
        if(p.val==obj){
            p=delete(p);
        }else if(p.val>obj){
             p.left=deleteBST(p.left,obj);

        }else{
             p.right=deleteBST(p.right,obj);

        }
        return p;
    }
    //删除这个特定节点
    public  TreeNode delete(TreeNode node){
        TreeNode temp=null;
        if(node.left==null){
            node=node.right;
        }else if(node.right==null){
            node=node.left;
        }else{
            temp=node;
            TreeNode s=node;
            s=s.left;
            while(s.right!=null){
                temp=s;
                s=s.right;
            }
            temp.val=s.val;
            if(temp!=node){
                temp.right=s.left;
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
           if(temp.val==obj){
               length++;
               return length;
           }else if(temp.val>obj){
               temp=temp.left;
               length++;
           }else{
               temp=temp.right;
               length++;
           }
       }
       return 0;
    }
    //深度优先搜索遍历 DFS depth First Search，先序遍历
    public void DFS(TreeNode root){
        if(root==null){
            return;
        }else{
            System.out.print(root.val+" ");
            DFS(root.left);
            DFS(root.right);
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
            System.out.print(temp.val+" ");
            if(temp.left!=null){
                e.add(temp.left);
            }
            if(temp.right!=null){
                e.add(temp.right);
            }
        }
    }
    //求树的高度
    public int TreeDepth(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int left=TreeDepth(root.left);
            int right=TreeDepth(root.right);
            if(left>right){
                return left+1;
            }else{
                return right+1;
            }
        }
    }
    //给定一组整数数组去建立一颗二叉树，如果输入为-1，表示这个节点为空，当作广度优先插入
    public TreeNode DFSCreateTree(int[] nums){
        if(nums.length==0){
            return null;
        }
        TreeNode root=new TreeNode(nums[0]);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        //定义当前行的其实元素下标
        int startIndex=1;
        //当前行有多少元素
        int columnIndex=2;
        //换行
        while(!queue.isEmpty()){
            for(int i=startIndex;i<startIndex+columnIndex;i=i+2){
                if(i==nums.length) return root;
                TreeNode cur=queue.poll();
                if(nums[i]!=-1){
                    cur.left=new TreeNode(nums[i]);
                    queue.add(cur.left);
                }else{
                    cur.left=null;
                }
                if(i+1==nums.length) return root;
                if(nums[i+1]==-1){
                    cur.right=null;
                }else{
                    cur.right=new TreeNode(nums[i+1]);
                    queue.add(cur.right);
                }
            }
            startIndex=startIndex+columnIndex;
            //有的位置可能是空的
            columnIndex= queue.size()*2;
        }
        return root;
    }
}
