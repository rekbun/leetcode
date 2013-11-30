/*
http://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenLinkedList {
	class TreeNodeRef {
		TreeNode node;
	}
	public void flattenUtil(TreeNode root,TreeNodeRef prev) {
		if(root==null) {
			return ;
		}
		TreeNode right=root.right;
		TreeNode left=root.left;
		if(prev.node!=null) {
			prev.node.left=null;
			prev.node.right=root;
		}
		prev.node=root;

		flattenUtil(root.left,prev);
		flattenUtil(right,prev);

	}

	public void flatten(TreeNode root) {
		if(root==null) {
			return ;
		}
		TreeNodeRef ref=new TreeNodeRef() ;
		flattenUtil(root,ref);
	}
}
