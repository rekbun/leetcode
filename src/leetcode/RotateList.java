package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/26/13
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class RotateList {
	public ListNode rotateRight(ListNode root,int k) {
		if(root==null|| k==0) {
			return root;
		}
		ListNode slow=root;
		int len=0;
		while(slow!=null) {
			len++;
			slow=slow.next;
		}
		k=k%len;
		slow=root;
		ListNode fast=root;
		while(k-->0&& fast!=null) {
			fast=fast.next;
		}
		if(fast==null|| root.next==null) {
			return root;
		}
		while(fast.next!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		fast.next=root;
		root=slow.next;
		slow.next=null;

		return root;
	}
}
