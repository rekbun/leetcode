import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/20/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum2 {
	private void combinationSum2Util(int[] num,int idx,int target,ArrayList<ArrayList<Integer>> sol,ArrayList<Integer> list) {
		if(target==0) {
			if(!sol.isEmpty() && sol.get(sol.size()-1).equals(list)) {
				return;
			}
			sol.add(list);
			return;
		}
		if(idx>=num.length || target<0) {
			return;
		}
		ArrayList<Integer> numList=new ArrayList<Integer>(list);
		list.add(num[idx]);
		combinationSum2Util(num,idx+1,target-num[idx],sol,list);
	    list=numList;
		while(idx<num.length-1 && num[idx]==num[idx+1]) {
			idx++;
		}
		combinationSum2Util(num,idx+1,target,sol,list);
	}
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num,int k) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		combinationSum2Util(num,0,k,sol,new ArrayList<Integer>());
		return sol;
	}
}
