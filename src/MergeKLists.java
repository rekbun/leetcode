import java.util.ArrayList;

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
public class MergeKLists {
    private ListNode mergeList(ListNode list1,ListNode list2) {
        ListNode head= list1;
        ListNode last=null;
        while(list1!=null && list2!=null) {
            if(list1.val<list2.val) {
                last=list1;
                list1=list1.next;
            }else {
                if(last==null) {
                    last=list2;
                    head=list2;
                }else {
                    last.next=list2;
                    last=last.next;
                }
                ListNode tmp= list2.next;
                list2.next=list1;
                list2=tmp;
                

            }
        }
        if(list2!=null) {
            if(last!=null)
            last.next=list2;
        }
        if(list1!=null) {
            if(last!=null) {
                last.next=list1;
            }
        }
        return head;
    }
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null || lists.size()<=0) {
            return null;
        }
        ListNode ret= null;
        for(int i=0;i<lists.size();i++) {
            if(ret==null && lists.get(i)!=null) {
                ret= lists.get(i);
            }else {
                ret=mergeList(ret,lists.get(i));
            }
        }
        return ret;
    } 
}

