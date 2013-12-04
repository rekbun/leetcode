/*
http://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
	class Sum{
		int max;
		Sum() {
			max=0;
		}
	}
	public int maxPathSum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		Sum cur=new Sum();

		Sum maxSum=new Sum();
		return maxPathSumUtil(root,cur);
	}

	int maxPathSumUtil(TreeNode root,Sum cur) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		Sum left=new Sum();
		int l=maxPathSumUtil(root.left,left);
		Sum right=new Sum();
		int r=maxPathSumUtil(root.right,right);
		cur.max=Math.max(Math.max(left.max+root.val,right.max+root.val),root.val);

		return Math.max(Math.max(l,r),Math.max(cur.max,root.val+left.max+right.max));
	}
}
