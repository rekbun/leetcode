package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/20/13
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum {
	private void combinationSumUtil(int[] candidates, int idx, int target,ArrayList<ArrayList<Integer>> sol,ArrayList<Integer> list ) {
		if(target==0) {
			sol.add(list);
			return;
		}
		if(target<0 || idx>=candidates.length) {
			return ;
		}
		ArrayList<Integer> num = new ArrayList<Integer>(list);
		list.add(candidates[idx]);
		combinationSumUtil(candidates, idx, target - candidates[idx], sol, list);
		list=num;
		combinationSumUtil(candidates, idx + 1, target, sol,list);
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,int target) {
		Arrays.sort(candidates);
		ArrayList<ArrayList<Integer>> sol= new ArrayList<ArrayList<Integer>>();
		combinationSumUtil(candidates,0,target,sol,new ArrayList<Integer>());
		return sol;
	}

}
