import java.util.ArrayList;

public class TreeNodeyeziNodedigui {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //list1是作为返回值，list2作为节点存储值
    ArrayList<ArrayList<Integer>> list1=new ArrayList<>();
    ArrayList<Integer> list2=new ArrayList<>();
    ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    ArrayList<Integer> path=new ArrayList<>();
    //输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null){
            return list;
        }
        path.add(root.val);
        if(target==root.val&&root.left==null&&root.right==null){
            list.add(new ArrayList<Integer>(path));
        }
        if(target>root.val){
            if(root.left!=null){
                FindPath(root.left,target-root.val);
            }
            if(root.right!=null){
                FindPath(root.right,target-root.val);
            }
        }
        path.remove(path.size()-1);
        return list;
    }
    //求树根节点到每个叶子节点的和
    public ArrayList<ArrayList<Integer>> FindSum(TreeNode root){
        if(root==null){
            return list1;
        }
        list2.add(root.val);
        if(root.left==null&&root.right==null){
            //不能直接存入list2，因为之后list2变动也会影响list1，所以应该给一个新的数组，完全赋值list1
            list1.add(new ArrayList<>(list2));
        }
        if(root.left!=null){
            FindSum(root.left);
        }
        if(root.right!=null){
            FindSum(root.right);
        }
        list2.remove(list2.size()-1);
        return list1;
    }
    public static void main(String[] args) {
        TreeNode node_10 = new TreeNode(10);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_12 = new TreeNode(12);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_7 = new TreeNode(7);

        node_10.left = node_5;
        node_10.right = node_12;
        node_5.left = node_4;
        node_5.right = node_7;
        System.out.println(new TreeNodeyeziNodedigui().FindSum(node_10));

//    System.out.println(new Solution().FindPath(node_10, 22));
    }

}