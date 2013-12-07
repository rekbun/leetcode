/*
http://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class FindSumOfPath {
	public int sumNumbers(TreeNode root) {
		if(root==null) {
			return 0;
		}

		return sumNumbersUtil(root,0);

	}


	public int sumNumbersUtil(TreeNode root,int num) {
		if(root==null) {
			return 0;
		}
		num=num*10+root.val;
		if(root.left==null && root.right==null) {
			return num;
		}
		return sumNumbersUtil(root.left,num)+sumNumbersUtil(root.right,num);
	}
}
