package leetcode;

import java.util.Stack;

public class LongestValidParenthes {
    private class StackObject {
		char val;
		int bef;
		int aft;
		public StackObject(char val,int bef,int aft) {
			this.val=val;
			this.bef=bef;
			this.aft=aft;
		}
	}
	public int longestValidParentheses(String s) {
		if(s==null||s.length()==0) {
			return 0;
		}
		Stack<StackObject> stack=new Stack<StackObject>();
		int aft=0;
		int ret=0;
		for(int i=0;i<s.length();i++) {
			switch(s.charAt(i)) {
			case '(':
				if(!stack.empty()) {
					stack.push(new StackObject('(',stack.peek().aft,0));
				}else {
					stack.push(new StackObject('(',aft,0));
				}
				aft=0;
				break;
			case ')':
				if(!stack.empty()) {
					int x=stack.peek().bef+stack.peek().aft+1;
					if(ret<=(x)) {
						ret=(x);
					}
		    		aft=x;
					stack.pop();
					if(!stack.empty()) {
						stack.peek().aft=x;
					}
				}else {
					aft=0;
				}
				break;
			}
		}
		return 2*ret;
	}
}
