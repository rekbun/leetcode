/*tion for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class AddTwoNumbers {
   public ListNode addTwoNumbers(ListNode l1,ListNode l2)
    {
        if(l1==null||l2==null) {
            return (l1==null)?l2:l1;
        }
        ListNode itr1=l1,itr2=l2;
        ListNode head=null;
        ListNode retItr=null;
        int s;
        int c=0;
        while(itr1!=null && itr2!=null) {
           s=(itr1.val+itr2.val+c)%10;
           c=(itr1.val+itr2.val+c)/10;
           if(head==null) {
               retItr=new ListNode(s);
               head=retItr;
           }else {
               retItr.next=new ListNode(s);
               retItr=retItr.next;
           }
           itr1=itr1.next;
           itr2=itr2.next;
        }
        while(itr1!=null) {
            s=(itr1.val+c)%10;
            c=(itr1.val+c)/10;        
            retItr.next=new ListNode(s);
            retItr=retItr.next;
            itr1=itr1.next;
        }
        while(itr2!=null) {
            s=(itr2.val+c)%10;
            c=(itr2.val+c)/10;
            retItr.next=new ListNode(s);
            retItr=retItr.next;
            itr2=itr2.next;
        }
        if(c>0) {
            retItr.next=new ListNode(c);
        }
        return head;
    }
}
