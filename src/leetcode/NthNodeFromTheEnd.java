package leetcode;

/*
http://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class NthNodeFromTheEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head;
		ListNode second = head;
		for(int i = 0;i < n;i++){
			first = first.next;
		}
		if(first == null) return head.next;
		while(first.next != null){
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return head;
	}
}
