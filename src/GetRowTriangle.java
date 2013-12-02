import java.util.ArrayList;

/*
http://oj.leetcode.com/problems/pascals-triangle-ii/
 */
public class GetRowTriangle {
	public ArrayList<Integer> getRow(int n) {
		ArrayList<Integer> ret=new ArrayList<Integer>();
		n++;
		ArrayList<Integer> cur=new ArrayList<Integer>();

		for(int i=1;i<=n;i++) {
			if(i==1) {
				ret.add(1);
			}
			cur=new ArrayList<Integer>();
			for(int j=1;j<=i;j++) {
				if(j==1 ||j==i ) {
					cur.add(1);
				}else {
					cur.add(ret.get(j-2)+ret.get(j-1));
				}
			}
			ret=cur;
		}
		return ret;
	}
}
