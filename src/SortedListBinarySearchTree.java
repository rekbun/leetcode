/*
http://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class SortedListBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) {
			return null;
		}

		ListNode cur=head;
		int len=0;
		while(cur!=null) {
			len++;
			cur=cur.next;
		}
		ListNodeRef headRef=new ListNodeRef();
		headRef.head=head;
		return sortedListToBSTUtil(headRef,1,len);
	}
	class ListNodeRef {
		ListNode head;
	}
	private TreeNode sortedListToBSTUtil(ListNodeRef headRef, int s, int e) {
		if(s>e){
			return null;
		}
		int mid=(s+e)/2;
		TreeNode left=sortedListToBSTUtil(headRef, s,mid-1);
		TreeNode root=new TreeNode(headRef.head.val);
		headRef.head=headRef.head.next;
		root.left=left;
		root.right=sortedListToBSTUtil(headRef, mid+1, e);
		return root;
	}
}
