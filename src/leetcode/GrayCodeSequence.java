package leetcode;

import java.util.ArrayList;

/*
http://oj.leetcode.com/problems/gray-code/
 */
public class GrayCodeSequence {
	public ArrayList<Integer> grayCode(int n) {
		if(n==0) {
			ArrayList<Integer> ret= new ArrayList<Integer>();
			ret.add(0);
			return ret;

		}


		return grayCodeUtil(n);
	}

	private ArrayList<Integer> grayCodeUtil(int n) {
		ArrayList<Integer> ret=new ArrayList<Integer>();
		if(n==1) {
			ret.add(1);
			ret.add(0);
			return ret;
		}

		ArrayList<Integer> gray=new ArrayList<Integer>();
		for(Integer el:grayCodeUtil(--n)) {
			ret.add(new Integer(el));
			gray.add(0,new Integer((1<<(n-1))+el));
		}
		ret.addAll(gray);
		return ret;
	}
}
