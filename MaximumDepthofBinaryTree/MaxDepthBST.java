/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * recursion method and iterative post-order method
 * 
 */
import java.util.*;


public class MaxDepthBST {

	public static void main (String[] args){

		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(1);
		TreeNode left2 = new TreeNode(1);

		root.left = left;
		root.right = right;
		left.left = left2;

		RecursiveSolution rso = new RecursiveSolution();
		int depth = rso.maxDepth(root);
		System.out.println("Depth of BST(Recursive) is:" + depth);

    IterativeSolution iso = new IterativeSolution();
    int depth2 = iso.maxDepth(root);
    System.out.println("Depth of BST(Iterative) is:" + depth2);

	}


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



class RecursiveSolution {
    public int maxDepth(TreeNode root) {
  
        if(root == null)
            return 0;
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
            return (left_depth > right_depth) ? left_depth + 1: right_depth + 1;
    }
} 



class IterativeSolution {
    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;
  		Stack<TreeNode> s = new Stack<TreeNode>();

  		s.push(root);
  		int maxDepth = 0;
  		TreeNode prev = null;
  		while (!s.empty()) {
  		  TreeNode curr = s.peek();
  		  if ( prev == null || prev.left == curr || prev.right == curr) {
  		    if (curr.left != null)
  		      s.push(curr.left);
  		    else if (curr.right != null)
  		      s.push(curr.right);
  		  } else if (curr.left == prev) {
  		    if (curr.right != null)
  		      s.push(curr.right);
  		  } else {
  		    s.pop();
  		  }
  		  prev = curr;
  		  if (s.size() > maxDepth)
  		    maxDepth = s.size();
  		}
  		return maxDepth;

    }
}


