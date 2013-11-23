import java.util.Stack;

/*
http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
class StackElement {
	int s;
	int e;
	int val;

	StackElement(int s, int e, int val) {
		this.s = s;
		this.e = e;
		this.val = val;
	}
}

public class LargestRectangleArea {
	public int largestRectangleArea(int[] histogram) {
		if (histogram.length == 0) {
			return 0;
		}
		int max = 0;
		Stack<StackElement> stack = new Stack<StackElement>();
		for (int i = 0; i < histogram.length; i++) {
			StackElement el=null;
			int start=i;
			while (!stack.empty() && histogram[i] < stack.peek().val) {
				start=stack.peek().s;
				max = calculateMax(max, stack, i);
			}
			el = new StackElement(start, i, histogram[i]);
			stack.push(el);
		}
		while (!stack.empty()) {
			max=calculateMax(max,stack,histogram.length);
		}
		return max;
	}

	private int calculateMax(int max, Stack<StackElement> stack, int i) {
		StackElement el;
		el = stack.peek();
		if (max < (i - el.s) * el.val) {
			max = (i - el.s) * el.val;
		}
		stack.pop();
		return max;
	}
}
