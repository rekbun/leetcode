package leetcode;

/*
http://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return left < right ? right + 1 : left + 1;
	}
}
