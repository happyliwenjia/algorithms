import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
   static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;

    }

  }
  public static void main(String[] args) {

    Solution demo = new Solution();
    TreeNode node_8 = new TreeNode(8);
    TreeNode node_6 = new TreeNode(6);
    TreeNode node_62 = new TreeNode(6);
    TreeNode node_5 = new TreeNode(5);
    TreeNode node_7 = new TreeNode(7);
    TreeNode node_72 = new TreeNode(7);
    TreeNode node_52 = new TreeNode(5);
    node_8.left = node_6;
    node_8.right = node_62;
    node_6.left = node_5;
    node_6.right = node_7;
    node_62.left = node_52;
    node_62.right = node_72;
    System.out.println(demo.isSymmetrical(node_8));
  }
  boolean isSymmetrical(TreeNode pRoot)
  {
    if(pRoot==null){
      return true;
    }
    return isleftequalright(pRoot.left,pRoot.right);
  }
  public boolean isleftequalright(TreeNode root1,TreeNode root2){
    if(root1==null&&root2==null){
      return true;
    }else if(root1==null||root2==null){
      return false;
    }
    if(root1.val!=root2.val){
      return false;
    }else{
      return isleftequalright(root1.left,root2.left)&&isleftequalright(root1.right,root2.right);
    }
  }




}