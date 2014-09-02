package leetcode;

/*
http://oj.leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {
	class ReturnNodes{
		TreeNode n1;
		TreeNode n2;
		TreeNode prev;
	}
	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		ReturnNodes nodes= new ReturnNodes();

		recoverTreeUtil(root,nodes);
		swap(nodes.n1,nodes.n2);

	}



	private void recoverTreeUtil(TreeNode root,ReturnNodes nodes) {
		if (root == null) {
			return ;
		}

		recoverTreeUtil(root.left,nodes);
		if(nodes.prev!=null) {
			if(nodes.prev.val>root.val) {
				if(nodes.n1==null) {
					nodes.n1=nodes.prev;
				}
				nodes.n2=root;
			}
		}
		nodes.prev=root;
		recoverTreeUtil(root.right,nodes);

	}

	private void swap(TreeNode first, TreeNode second) {
		if(first==null || second==null) {
			return;
		}
		int val = first.val;
		first.val = second.val;
		second.val = val;
	}
}
