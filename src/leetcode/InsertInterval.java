package leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/25/13
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,Interval ni) {
		ArrayList<Interval> ret= new ArrayList<Interval>();
		if(intervals.size()==0) {
			ret.add(ni);
		}
		for(Interval el:intervals) {
			ret.add(new Interval(el.start,el.end));
		}
		boolean inserted=false;
		for(int i=0;i<ret.size();i++) {
            if(ret.get(i).start>ni.start) {
                ret.add(i,ni);
	            inserted=true;
                break;
            }
		}
		if(!inserted) {
			ret.add(ni);
		}


		for(int i=1;i<ret.size();) {
			Interval interval= ret.get(i);
			if(interval.start<=ret.get(i-1).end) {
				ret.get(i-1).end=Math.max(interval.end,ret.get(i-1).end);
				ret.remove(i);
			}else {
				i++;
			}
		}
		return ret;
	}
}
