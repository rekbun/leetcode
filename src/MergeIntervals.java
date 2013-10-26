import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Collections;

public class MergeIntervals {
	private int partition(ArrayList<Interval> list,int s,int e) {
		Interval pivot=list.get(e);
		int j=s-1;
		for(int i=s;i<e;i++) {
			if(list.get(i).end<=pivot.end) {
				Collections.swap(list,i,++j);
			}
		}
		Collections.swap(list,j+1,e);
		return j+1;
	}

	private void sort(ArrayList<Interval> list,int s,int e) {
		if(s>e) {
			return;
		}
		int pivot=partition(list,s,e);
		sort(list, s, pivot-1);
		sort(list, pivot+1, e);
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if(intervals==null|| intervals.size()==0||intervals.size()==1) {
			return intervals;
		}

		sort(intervals,0,intervals.size()-1);
		ArrayList<Interval> ret= new ArrayList<Interval>(intervals);
		for(int i=1;i<ret.size();) {
			if(ret.get(i).start<=ret.get(i-1).end) {
				ret.get(i-1).end=ret.get(i).end;
				if(ret.get(i-1).start>ret.get(i).start) {
					if(i>1) {
						i--;
					}
				}
				ret.get(i-1).start=Math.min(ret.get(i-1).start,ret.get(i).start);
				ret.remove(i);

			}else {
				i++;
			}

		}
		return ret;
	}
}
