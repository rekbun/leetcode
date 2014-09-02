package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
http://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
		if(root==null) {
			return ret;
		}
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(root);
		int cnt=1;
		ArrayList<Integer> cur=new ArrayList<Integer>();
		cur.add(root.val);
		ret.add(cur);
		while (!q.isEmpty()) {
			cur=new ArrayList<Integer>();
			int cnt_cur=0;
			while (cnt-->0) {
				TreeNode node=q.remove();
				if(node.left!=null) {
					q.add(node.left);
					cur.add(node.left.val);
					cnt_cur++;
				}
				if(node.right!=null) {
					q.add(node.right);
					cur.add(node.right.val);
					cnt_cur++;
				}
			}
			if(cur.size()>0) {
				ret.add(cur);
			}
			cnt=cnt_cur;
		}
		return ret;
	}
}
