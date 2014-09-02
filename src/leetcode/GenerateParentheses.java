package leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/8/13
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class GenerateParentheses {
	void generateParenthese(int x,int y,int n,ArrayList<String> al,String str) {
		if(x==n && y==n) {
			al.add(str);
		}
		if(x<y || x>n) {
			return;
		}
		generateParenthese(x + 1, y, n, al, str + "(");
		generateParenthese(x, y + 1, n, al, str + ")");
	}
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> list=new ArrayList<String>();
	    generateParenthese(0,0,n,list,"");
		return list;
	}
}
