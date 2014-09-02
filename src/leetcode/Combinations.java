package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 11/6/13
 * Time: 10:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Combinations {
	private void combineUtil(int s,int n,int key,ArrayList<ArrayList<Integer>> ret,ArrayList<Integer> values) {
		if(key==0) {
			ArrayList<Integer> clone= new ArrayList<Integer>();
			for(int i=0;i<values.size();i++) {
				clone.add(values.get(i));
			}
			ret.add(clone);
			return;
		}
		if(s>=n) {
			return;
		}

		combineUtil(s+1,n,key,ret,values);
		values.add(s);
		combineUtil(s + 1, n, key + 1, ret, values);
		values.remove(values.size()-1);
	}

	public ArrayList<ArrayList<Integer>> combine(int n,int key) {
		ArrayList<ArrayList<Integer>> ret= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> values=new ArrayList<Integer>();
		combineUtil(1,n,key,ret,values);
		return ret;
	}
}
