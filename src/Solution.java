import java.util.ArrayList;

public class Solution {
  static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;

    }

  }
  //list1是作为返回值，list2作为节点存储值
  ArrayList<Integer> list1=new ArrayList<>();
  ArrayList<Integer> list2=new ArrayList<>();
  int sum=0;
 //求树根节点到每个叶子节点的和
  public ArrayList<Integer> FindSum(TreeNode root){
    if(root==null){
      return list1;
    }
    sum=sum+ root.val;
    if(root.left==null&&root.right==null){
      list1.add(sum);
      sum=sum-root.val;
    }
    if(root.left!=null){
      FindSum(root.left);
      sum=sum- root.val;
    }
    if(root.right!=null){
      FindSum(root.right);
      sum=sum- root.val;
    }
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
//    System.out.println(new Solution().FindPath(node_10, 22));
  }

}