package leetcode;

import java.util.ArrayList;

/*
http://oj.leetcode.com/problems/pascals-triangle/
 */
public class GeneratePattern {
	public ArrayList<ArrayList<Integer>> generate(int n) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (n == 0) {
			return ret;
		}
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		ret.add(list);
		for(int i=1;i<n;i++) {
			list=ret.get(i-1);
			ArrayList<Integer> nList=new ArrayList<Integer>();
			nList.add(list.get(0));
			for(int j=1;j<list.size();j++) {
				nList.add(list.get(j-1)+list.get(j));
			}
			nList.add(list.get(0));
			ret.add(nList);
		}
		return ret;
	}
}
