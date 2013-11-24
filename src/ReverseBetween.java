public class ReverseBetween {
	public ListNode reverseBetween(ListNode root,int m,int n) {
		if(root==null) {
			return root;
		}
		ListNode m_start=null;
		ListNode m_end;
		ListNode prev=null;
		ListNode cur=root;
		int x=m;
		while (cur.next!=null && m>1) {
			prev=cur;
			cur=cur.next;
			m--;
		}
		m_end=cur;
		m_start=cur;
		cur=cur.next;
		while (cur!=null && n>x) {
			ListNode temp=cur;
			cur=cur.next;
			temp.next=m_start;
			m_start=temp;
			n--;
		}
		if(prev!=null) {
			prev.next=m_start;
		}
		if(m_end!=null) {
			m_end.next=cur;
		}

		return x>1?root:m_start;
	}
}
