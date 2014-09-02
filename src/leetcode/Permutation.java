package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/23/13
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Permutation {
	private void permuteUtil(ArrayList<Integer> num,int idx,ArrayList<ArrayList<Integer>> ret) {
		if(idx==num.size()) {
			ArrayList<Integer> x= new ArrayList<Integer>(num);
			ret.add(x);
			return;
		}

		for(int i=idx;i<num.size();i++) {
			Collections.swap(num, i, idx);
			permuteUtil(num,idx+1,ret);
			Collections.swap(num, i, idx);
		}
	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> ret= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> cur= new ArrayList<Integer>();
		for(int i=0;i<num.length;i++) {
			cur.add(num[i]);
		}

		permuteUtil(cur,0,ret);
		return ret;
	}
}
