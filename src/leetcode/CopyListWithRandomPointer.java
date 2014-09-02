package leetcode;/*
http://oj.leetcode.com/problems/copy-list-with-random-pointer/
 */
import java.util.HashMap;
public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newRoot = head;
		while (head != null) {
			if (!map.containsKey(head)) {
				map.put(head, new RandomListNode(head.label));
			}
			if (head.next != null && !map.containsKey(head.next)) {
				RandomListNode next = new RandomListNode(head.next.label);
				map.get(head).next = next;
				map.put(head.next, next);
			} else {
				map.get(head).next = map.get(head.next);
			}
			if (head.random != null && !map.containsKey(head.random)) {
				RandomListNode random = new RandomListNode(head.random.label);
				map.get(head).random = random;
				map.put(head.random, random);
			} else {
				map.get(head).random = map.get(head.random);
			}

			head = head.next;
		}
		return map.get(newRoot);
	}
}
