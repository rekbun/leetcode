/*
http://oj.leetcode.com/problems/reorder-list/
 */
public class ReoderList {
	public ListNode reverse(ListNode head) {
		ListNode newHead=null;
		while(head!=null) {
			ListNode tmp=head.next;
			head.next=newHead;
			newHead=head;
			head=tmp;
		}
		return newHead;
	}
	public void reorderList(ListNode head) {
		if(head==null) {
			return;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}

		ListNode newList=slow.next;
		newList=reverse(newList);
		slow.next=null;
		while(head!=null) {
			if(newList!=null) {
				ListNode tmp=head.next;
				head.next=newList;
				ListNode tmp1=newList.next;
				newList.next=tmp;
				newList=tmp1;
				head=tmp;
			}else{
				head=head.next;
			}
		}

	}
}

