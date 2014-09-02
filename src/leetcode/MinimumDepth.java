package leetcode;

/*
http://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepth {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int l = minDepth(root.left);
		int r = minDepth(root.right);

		return l < r ? (l > 0 ? l + 1 : r + 1) : (r > 0 ? r + 1 : l + 1);
	}
}
