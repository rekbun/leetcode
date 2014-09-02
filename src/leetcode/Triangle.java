package leetcode;

import java.util.ArrayList;

/*
http://oj.leetcode.com/problems/triangle/
 */
public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if(triangle.size()==0) {
			return 0;
		}
		int[] cur=new int[triangle.get(triangle.size()-1).size()];
		for(int i=0;i<cur.length;i++) {
			cur[i]=triangle.get(triangle.size()-1).get(i);
		}
		int len=cur.length;
		for(int i=triangle.size()-2;i>=0;i--) {
			for(int j=0;j<len-1;j++) {
				cur[j]=Math.min(cur[j]+triangle.get(i).get(j),cur[j+1]+triangle.get(i).get(j));
			}
			len--;
		}
		return cur[0];
	}
}
