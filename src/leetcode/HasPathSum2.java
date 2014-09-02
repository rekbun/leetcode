package leetcode;

import java.util.ArrayList;

/*
http://oj.leetcode.com/problems/path-sum-ii/
 */
public class HasPathSum2 {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root,int sum) {

		ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
		if(root==null) {
			return ret;
		}

		if(root.left==null && root.right==null&& root.val==sum) {
			ArrayList<Integer> el=new ArrayList<Integer>();
			el.add(root.val);
			ret.add(el);
			return ret;
		}

		if(root.left!=null) {
			for(ArrayList<Integer> list:pathSum(root.left, sum-root.val)) {
				list.add(0,root.val);
				ret.add(list);
			}
		}

		if(root.right!=null) {
			for(ArrayList<Integer> list:pathSum(root.right,sum-root.val)) {
				list.add(0,root.val);
				ret.add(list);
			}
		}
		return ret;
	}
}

