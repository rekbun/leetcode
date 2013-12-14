/*
    http://oj.leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head==null) {
			return head;
		}

		ListNode end=null;
		ListNode i=head;
		ListNode p_i=null;
		while(i!=null) {
			ListNode j=head;
			ListNode prev=null;
			while(j!=i) {
				if(j.val<=i.val) {
					prev=j;
					j=j.next;
				}else {
					if(head==j) {
						head=i;
					}else {
						prev.next=i;
					}
					if(p_i!=null) {
						p_i.next=i.next;
					}
					i.next=j;
					i=p_i;
					break;
				}
			}
			p_i=i;
			i=i.next;
		}
		return head;
	}
}
