/*
http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class SetNextInAnyTree {
	public void connect(TreeLinkNode root) {
		if(root==null) {
			return;
		}
		TreeLinkNode cur=root;
		while (cur!=null) {
			TreeLinkNode next_level=cur;
			while (cur!=null) {
				if(cur.left!=null) {
					if(cur.right!=null) {
						cur.left.next=cur.right;
					}else {
						cur.left.next=cur.next;
					}
				}
				if(cur.right!=null) {
					cur.right.next=findNext(cur.next);
				}
				cur=cur.next;
			}
			cur=findNext(next_level);
		}

	}

	private TreeLinkNode findNext(TreeLinkNode next_level) {
		while (next_level!=null) {
			if(next_level.left!=null) {
				return next_level.left;
			}
			if(next_level.right!=null) {
				return next_level.right;
			}
			next_level=next_level.next;
		}
		return null;
	}

}
