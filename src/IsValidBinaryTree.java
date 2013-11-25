/*
http://oj.leetcode.com/problems/validate-binary-search-tree/
 */
public class IsValidBinaryTree {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	private boolean isValidBSTUtil(TreeNode root, int min, int max) {
		if(root==null) {
			return true;
		}
		if(root.val>min && root.val<max) {
			return isValidBSTUtil(root.left, min, root.val) && isValidBSTUtil(root.right, root.val, max);
		}else {
			return false;
		}
	}
}
