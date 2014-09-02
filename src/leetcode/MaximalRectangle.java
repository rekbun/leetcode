package leetcode;

import java.util.Stack;

/*
http://oj.leetcode.com/problems/maximal-rectangle/
 */


public class MaximalRectangle {
	class StackElement {
		int s;
		int val;

		StackElement(int s, int val) {
			this.s = s;
			this.val = val;
		}
	}

	public int maximalRectangle(char [][] src) {
		if(src.length==0) {
			return 0;
		}
		int max=0;
		int [] heights=new int[src[0].length];
		for(int row=0;row<src.length;row++) {
			for(int col=0;col<src[0].length;col++) {
				if(row==0) {
					heights[col]=src[row][col]=='1'?1:0;
				}else {
					if(src[row][col]=='1') {
						heights[col]+=1;
					}else {
						heights[col]=0;
					}
				}
			}

			int ret=largestRectangleArea(heights);
			if(max<ret) {
				max=ret;
			}

		}
		return max;
	}

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
			el = new StackElement(start, histogram[i]);
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
