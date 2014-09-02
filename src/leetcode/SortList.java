package leetcode;

/*
http://oj.leetcode.com/problems/sort-list/
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if(head==null) {
			return null;
		}

		mergeSortList(head);
		return head;
	}

	void quickSort(ListNode head,ListNode end) {
		if(head==null || head.next==end) {
			return;
		}

		ListNode i=partition(head,end);
		quickSort(head,i);
		quickSort(i,end);
	}

	ListNode partition(ListNode head,ListNode end) {
		ListNode i=head;
		int pivot=head.val;
		ListNode j=head.next;
		while(j!=end) {
			if(j.val<pivot) {
				int val=j.val;
				j.val=i.val;
				i.val=val;
				i=i.next;
			}
			j=j.next;
		}
		if(i==head) {
			return i.next;
		}
		return i;

	}
	public ListNode mergeSortList(ListNode head)
	{
		if ( (head == null) || (head.next == null))
			return head;
		ListNode middle = this.findMiddle(head);
		ListNode first = head;
		ListNode second = middle.next;
		middle.next = null;
		ListNode left = mergeSortList(first);
		ListNode right = mergeSortList(second);
		return merge(left, right);
	}

	public ListNode findMiddle(ListNode head) {
		ListNode slow=head;
		while(head.next!=null&& head.next.next!=null) {
			slow=slow.next;
			head=head.next;
			if(head.next!=null) {
				head=head.next;
			}
		}
		return slow;
	}

	public ListNode merge(ListNode left,ListNode right) {
		ListNode ret=null;
		ListNode cur_node=null;
		while(left!=null || right!=null) {
			if(right==null || (left!=null && left.val<right.val)) {
				if(ret==null) {
					ret=left;
					cur_node=ret;
					left=left.next;
				}else {
					cur_node.next=left;
					cur_node=cur_node.next;
					left=left.next;
					cur_node.next=null;
				}

			}else {
				if(ret==null) {
					ret=right;
					cur_node=ret;
					right=right.next;
				}else {
					cur_node.next=right;
					cur_node=cur_node.next;
					right=right.next;
					cur_node.next=null;
				}

			}
		}

		return ret;
	}
}
