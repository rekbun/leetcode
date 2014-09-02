package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/23/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Permutation2 {
	private boolean allSorted(int [] num) {
		for(int i=0;i<num.length-1;i++) {
			if(num[i]<num[i+1])  {
				return false;
			}
		}
		return true;
	}
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> ret= new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);

		while(true) {
			ArrayList<Integer> cur= new ArrayList<Integer>();

			for(int i=0;i<num.length;i++) {
				cur.add(num[i]);
			}
			if(ret.isEmpty()) {
				ret.add(cur);
			}else {
				ArrayList<Integer> lastEl=ret.get(ret.size()-1);
				for(int i=0;i<cur.size();i++) {
					if(cur.get(i)!=lastEl.get(i)) {
						ret.add(cur);
						break;
					}else {
						continue;
					}
				}
			}
			if(allSorted(num)) {
				return ret;
			}
			nextPermutation(num);
		}

	}


	private int findRightLow(int[] src) {
		int low=-1;
		for(int i=1;i<src.length;i++) {
			if(src[i]>src[i-1]) {
				low=i-1;
			}
		}
		return low;
	}

	private  int findLeftLow(int[] src,int si) {
		int high=si+1;
		for(int i=si+1;i<src.length;i++) {
			if(src[i]<=src[high] && src[i]>src[si]) {
				high=i;
			}
		}
		return high;
	}

	private void swap(int[] src,int fi,int ei) {
		int temp=src[fi];
		src[fi]=src[ei];
		src[ei]=temp;
	}

	private void reverse(int[] src,int si) {
		int j=src.length-1;
		for(int i=si;i<j;i++,j--) {
			swap(src, i, j);
		}
	}
	public void nextPermutation(int[] src) {
		if(src==null || src.length==0) {
			return;
		}

		int fi=findRightLow(src);
		if(fi==-1) {
			//Arrays.sort(src);
			return;
		}
		int ei=findLeftLow(src,fi);
		swap(src,fi,ei);
		reverse(src,fi+1);
	}
}
