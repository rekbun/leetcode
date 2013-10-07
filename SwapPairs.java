/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode prev=null;
        ListNode cur=head;
        ListNode next=head.next;
        head=next;
        while(next!=null)  {
            ListNode temp = next.next;
            next.next=cur;
            cur.next=temp;
            if(prev!=null) {
                prev.next=next;
            }
            prev=cur;
            cur=temp;
            if(temp==null) {
                break;
            }
            next=temp.next;
        }
        return head;
    }        
}
