tion for singly-linked list.
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
    public ListNode reverse(ListNodeWrapper wrapper,int k) {
        ListNode head = wrapper.head;
        if(head==null)  {
            return head;
        }
        ListNode last=head;
        ListNode cur=head;
        ListNode prev=null;
        while(k-->0)    {
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        last.next=cur;
        wrapper.head=cur;
        return prev;
    }
    class ListNodeWrapper
    {
        ListNode head;
    }
    public ListNode reverseKGroup(ListNode head,int k) {
        if(head==null)  {
            return null;
        }
        ListNode cur=head;
        int len=0;
        while(cur!=null) {
           cur=cur.next;
           len++;
        }
        ListNode prev=null;
        ListNodeWrapper wrapper= new ListNodeWrapper();
        if(k==1) {
            return head;
        }
        cur=head;
        while(len>=k) {
            wrapper.head=cur;
            ListNode temp=cur;
            if(prev!=null) {
                prev.next=reverse(wrapper,k);
            }else {
                prev=reverse(wrapper,k);
                head=prev;
            }
            prev=temp;
            cur=wrapper.head;
            len-=k;
        }
        return head;
    }
}
