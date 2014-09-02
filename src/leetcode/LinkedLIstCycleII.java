package leetcode;

/*
http://oj.leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedLIstCycleII {
	public ListNode detectCycle(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode s=head;
		ListNode f=head.next;
		while(s!=f && f!=null && f.next!=null) {
			s=s.next;
			f=f.next.next;
		}

		if(s==f && f!=null && f.next!=null) {
			s=head;
			while(s!=f.next) {
				s=s.next;
				f=f.next;
			}
			return s;
		}
		return null;
	}
}
