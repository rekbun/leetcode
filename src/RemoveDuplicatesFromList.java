/*
	http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromList {
	public ListNode deleteDuplicates(ListNode node) {
		if(node==null) {
			return node;
		}
		ListNode ret=new ListNode(node.val);
		ListNode cur=node;

		ListNode retItr=ret;
		while (cur!=null) {
			if(retItr.val!=cur.val) {
				retItr.next=new ListNode(cur.val);
				retItr=retItr.next;
			}
			cur=cur.next;
		}
		return ret;
	}

}
