/*

 */

class TreeNodeWithRightPointer {
	int val;
	TreeNodeWithRightPointer left;
	TreeNodeWithRightPointer right;
	TreeNodeWithRightPointer rightPointer;
}
public class ConnectRightPointer {
	public void connectRightPointer(TreeNodeWithRightPointer root) {
		if(root==null) {
			return;
		}
		TreeNodeWithRightPointer cur=root;
		while (cur!=null) {
			TreeNodeWithRightPointer next_level=cur;
			while (cur!=null) {
				if(cur.left!=null) {
					if(cur.right!=null) {
						cur.left.rightPointer=cur.right;
					}else {
						cur.left.rightPointer=cur.rightPointer;
					}
				}
				if(cur.right!=null) {
					cur.right.rightPointer=cur.rightPointer;
				}
				cur=cur.rightPointer;
			}
			cur=findNext(next_level);
		}

	}

	private TreeNodeWithRightPointer findNext(TreeNodeWithRightPointer next_level) {
		while (next_level!=null) {
			if(next_level.left!=null) {
				return next_level.left;
			}
			if(next_level.right!=null) {
				return next_level.right;
			}
			next_level=next_level.rightPointer;
		}
		return null;
	}
}
