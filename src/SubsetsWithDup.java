import java.util.*;

public class SubsetsWithDup {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int [] src) {
		Arrays.sort(src);
		HashMap<ArrayList<Integer>,Boolean> map=new HashMap<ArrayList<Integer>, Boolean>();
		for(int i=0;i<Math.pow(2,src.length);i++) {
			ArrayList<Integer> seq=new ArrayList<Integer>();
			int val=i;
			int idx=0;
			while(val>0) {
				int x=val&1;
				if(x==1&& idx<src.length) {
					seq.add(src[idx]);
				}
				val>>=1;
				idx++;
			}

			if(!map.containsKey(seq)) {
				map.put(seq,Boolean.TRUE);
			}
		}
		ArrayList<ArrayList<Integer>> ret=new ArrayList<ArrayList<Integer>>();
		Set<ArrayList<Integer>> set=map.keySet();
		Iterator<ArrayList<Integer>> iterator = set.iterator();
		while(iterator.hasNext()) {
			ret.add(iterator.next());
		}
		return ret;
	}
	
}
