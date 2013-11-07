import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 11/7/13
 * Time: 9:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Subsets {

	private ArrayList<ArrayList<Integer>> subsetsUtil(int []src,int k) {
		if(k==src.length) {
			ArrayList<ArrayList<Integer>> x= new ArrayList<ArrayList<Integer>>();
			x.add(new ArrayList<Integer>());
			return x;
		}

		ArrayList<ArrayList<Integer>> ret= subsetsUtil(src,k+1);
		ArrayList<ArrayList<Integer>> nRet=new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> e:ret) {
			nRet.add(e);
			ArrayList<Integer> n=new ArrayList<Integer>();
			n.add(src[k]);
			for(int i=0;i<e.size();i++) {
				n.add(e.get(i));
			}
			nRet.add(n);
		}
		return  nRet;

	}

	public ArrayList<ArrayList<Integer>> subsets(int [] s) {
		Arrays.sort(s);
		return subsetsUtil(s,0);
	}

}
