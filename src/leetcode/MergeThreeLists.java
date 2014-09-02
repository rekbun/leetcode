package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/8/13
 * Time: 12:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class MergeThreeLists {
	public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
		if(l1==null && l2==null) {
			return l1;
		}
		if(l1==null || l2==null) {
			return l1!=null?l1:l2;
		}
		ListNode prev =null;
		ListNode head=l1;
		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
				if(head==null) {
					head=l1;
				}
				prev=l1;
				l1=l1.next;
			}else {
				if(prev==null) {
					head=l2;

				}else {
					prev.next=l2;
				}
				prev=l2;
				ListNode temp=l2;
				l2=l2.next;
				temp.next=l1;
			}

		}
		if(l2!=null) {
			prev.next=l2;
		}
		return head;
	}
}
