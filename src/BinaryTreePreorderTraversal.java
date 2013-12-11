/*
http://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 */
import java.util.ArrayList;

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> ret=new ArrayList<Integer>();
		if(root==null) {
			return ret;
		}

		preorderTraversalUtil(root,ret);
		return ret;
	}

	private void preorderTraversalUtil(TreeNode root,ArrayList<Integer> ret) {
		if(root==null) {
			return ;
		}

		ret.add(root.val);
		preorderTraversalUtil(root.left,ret);
		preorderTraversalUtil(root.right,ret);
	}
}
