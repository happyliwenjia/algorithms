import java.util.Scanner;


public class getTreeNodelength {
    class TreeNode{
        int val;
        TreeNode left=null;
        TreeNode right=null;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        getTreeNodelength tree=new getTreeNodelength();
        TreeNode root=null;
        String temp=input.nextLine();
        String[] a=temp.split("\\s+");
        for(int i=0;i<a.length;i++){
            root=tree.insert(root,Integer.valueOf(a[i]));
        }
        int maxLength=0;
        int length=0;
//        for(int i=0;i<a.length;i++){
//            length=tree.Search(root,Integer.valueOf(a[i]));
//            if(length>maxLength){
//                maxLength=length;
//            }
//        }
//        System.out.println(maxLength);
        System.out.print(tree.TreeDepth(root));
    }
    //插入二叉树
    public TreeNode insert(TreeNode root,int obj){
        TreeNode prev=null;
        TreeNode p=root;
        //p为待插入的位置，prev为需要求得的位置
        while(p!=null){
            prev=p;
            if(p.val>obj){
                p=p.left;
            }else if(p.val<obj){
                p=p.right;
            }else return root;
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
    //查询 长度
    public int Search(TreeNode root,int obj){
        TreeNode p=root;
        int length=0;
        while(p!=null){
            if(p.val==obj){
                length++;
                return length;
            }else if(p.val>obj){
                p=p.left;
                length++;
            }else{
                p=p.right;
                length++;
            }
        }
        return 0;
    }
    public int TreeDepth(TreeNode root) {
        int length=0;
        if(root.left==null&&root.right==null){
            return length+1;
        }else if(root.left==null){
            length=TreeDepth(root.right)+1;
        }else if(root.right==null){
            length=TreeDepth(root.left)+1;
        }else{
            int a=TreeDepth(root.left);
            int b=TreeDepth(root.right);
            if(a>=b){
                length=a+1;
            }else{
                length=b+1;
            }
        }
        return length;
    }
}
