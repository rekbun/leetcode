import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
http://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderTraversalBottom {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return ret;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		int cnt = 1;
		int cnt_cur;
		q.add(root);

		while (!q.isEmpty()) {
			cnt_cur = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (cnt-- > 0) {
				TreeNode node = q.remove();
				list.add(node.val);
				if (node.left != null) {
					q.add(node.left);
					cnt_cur++;
				}
				if (node.right != null) {
					q.add(node.right);
					cnt_cur++;
				}
			}
			cnt = cnt_cur;
			ret.add(0, list);
		}
		return ret;
	}
}
