package leetcode;

import java.util.ArrayList;

/*
http://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {

		return generateTreesUtil(1,n);
	}

	private ArrayList<TreeNode> generateTreesUtil(int s, int e) {
		ArrayList<TreeNode> ret=new ArrayList<TreeNode>();
		if(s>e) {
			ret.add(null);
			return ret;
		}

		TreeNode ans;
		for(int i=s;i<=e;i++) {
			ArrayList<TreeNode> leftTrees=generateTreesUtil(s,i-1);
			ArrayList<TreeNode> rightTrees=generateTreesUtil(i + 1, e);

			for(TreeNode left:leftTrees) {
				for(TreeNode right:rightTrees) {
					ans=new TreeNode(i);
					ans.left=left;
					ans.right=right;
					ret.add(ans);
				}
			}
		}
		return ret;
	}
}
