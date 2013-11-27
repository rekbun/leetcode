/*
http://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class SortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBSTUtil(num, 0, num.length - 1);
	}

	private TreeNode sortedArrayToBSTUtil(int[] num, int s, int e) {
		if (s > e) {
			return null;
		}

		int mid = (s + e) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBSTUtil(num, s, mid - 1);
		root.right = sortedArrayToBSTUtil(num, mid + 1, e);
		return root;
	}
}
