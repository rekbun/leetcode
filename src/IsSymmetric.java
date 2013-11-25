/*
http://oj.leetcode.com/problems/symmetric-tree/
 */
public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return true;
		}

		return isSymmetricUtil(root.left,root.right);
	}

	private boolean isSymmetricUtil(TreeNode p, TreeNode q) {
		if(p==null && q==null) {
			return true;
		}
		if(p==null ||q==null) {
			return false;
		}

		if(p.val!=q.val) {
			return false;
		}
		return isSymmetricUtil(p.left,q.right)&&isSymmetricUtil(p.right,q.left);
	}
}
