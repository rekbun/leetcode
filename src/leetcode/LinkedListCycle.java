package leetcode;

/*
http://oj.leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if(head==null) {
			return false;
		}
		ListNode slow=head;
		ListNode fast=head.next;

		while(slow!=fast && (fast!=null && fast.next!=null)) {
			slow=slow.next;
			fast=fast.next.next;
		}

		if(slow==fast && fast!=null && fast.next!=null) {
			return true;
		}
		return false;
	}
}
