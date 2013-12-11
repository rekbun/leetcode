/*
    http://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 */
import java.util.ArrayList;

public class PostorderTreeTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> ret=new ArrayList<Integer>();
		if(root==null) {
			return ret;
		}

		postorder(root,ret);
		return ret;
	}

	private void postorder(TreeNode root,ArrayList<Integer> ret) {
		if(root==null) {
			return;
		}

		postorder(root.left,ret);
		postorder(root.right,ret);
		ret.add(root.val);
	}
}
