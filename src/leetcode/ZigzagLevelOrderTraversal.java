package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
http://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
		if(root==null) {
			return ret;
		}
		Deque<TreeNode> q1=new LinkedList<TreeNode>();
		LinkedList<TreeNode> q2=new LinkedList<TreeNode>();
		ArrayList<Integer> cur=new ArrayList<Integer>();
		q1.add(root);
		int cnt=1;
		boolean odd=true;
		while(!q1.isEmpty()) {
			int cnt_cur=0;
			TreeNode node;
			cur=new ArrayList<Integer>();
			while (cnt-->0) {
				if(odd) {
					node=q1.removeFirst();
					if(node.left!=null) {
						cnt_cur++;
						q2.add(node.left);
					}
					if(node.right!=null) {
						cnt_cur++;
						q2.add(node.right);
					}
					cur.add(node.val);
				}else {
					node=q1.removeLast();
					if(node.right!=null) {
						cnt_cur++;
						q2.add(0,node.right);
					}
					if(node.left!=null) {
						cnt_cur++;
						q2.add(0,node.left);
					}
					cur.add(node.val);
				}
			}
			cnt=cnt_cur;

			q1.addAll(q2);
			q2.clear();
			ret.add(cur);
			odd=!odd;
		}
		return ret;
	}
}
