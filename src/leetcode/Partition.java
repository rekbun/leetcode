package leetcode;

/*
http://oj.leetcode.com/problems/partition-list/
 */
public class Partition {
	public ListNode partition(ListNode root,int x) {
		if(root==null) {
			return root;
		}

		ListNode less=null;
		ListNode ret=null;
		ListNode greater=null;
		ListNode greaterItr=null;
		while (root!=null) {
			if(x>root.val) {
				if(less==null) {
					less=new ListNode(root.val);
					ret=less;
				}else {
					less.next=new ListNode(root.val);
					less=less.next;
				}
			}else {
				if(greaterItr==null) {
					greaterItr=new ListNode(root.val);
					greater=greaterItr;
				}else {
					greaterItr.next=new ListNode(root.val);
					greaterItr=greaterItr.next;
				}
			}
			root=root.next;
		}
		if(ret!=null) {
			less.next=greater;
		}else {
			ret=greater;
		}
		return ret;
	}
}
