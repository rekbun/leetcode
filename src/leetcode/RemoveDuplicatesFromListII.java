package leetcode;

/*
http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromListII {
	public static ListNode deleteDuplicates(ListNode root) {
		if (root == null) {
			return root;
		}
		ListNode ret = new ListNode(root.val);
		ListNode prev = null;
		ListNode retItr = ret;
		root=root.next;
		boolean duplicate = false;
		while (root != null) {
			if (root.val == retItr.val) {
				duplicate = true;
			} else {
				if (duplicate) {
					retItr = prev;
				}
				if(retItr==null) {
					ret=new ListNode(root.val);
					retItr=ret;
				}else {
					retItr.next = new ListNode(root.val);
					prev = retItr;
					retItr = retItr.next;
				}
				duplicate =false;
			}
			root=root.next;
		}
		if (duplicate) {
			if(prev!=null) {
				prev.next = null;
			}else {
				return null;
			}
		}
		return ret;
	}}
