package leetcode;

/*
http://oj.leetcode.com/problems/path-sum/
 */
public class HasPathSum {
	public boolean hasPathSum(TreeNode root,int key) {
		if(root==null) {
			return false;
		}
		return hasPathSumUtil(root,key);
	}
	public boolean hasPathSumUtil(TreeNode root,int key) {
		if(root==null && key==0) {
			return true;
		}
		if(root==null) {
			return false;
		}
		return (root.left!=null?hasPathSumUtil(root.left, key-root.val):false)||(root.right!=null?hasPathSumUtil(root.right, key-root.val):((root.left==null && key-root.val==0)?true:false));
	}
}
