import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/24/13
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpriralOrder {
	public ArrayList<Integer> spiralOrder(int[][]matrix) {
		ArrayList<Integer> ret=new ArrayList<Integer>();
		if(matrix==null||matrix.length==0) {
			return ret;
		}
		int rs=0;
		int re=matrix.length-1;
		int ce=matrix[0].length-1;
		int cs=0;
	    while(rs<=re && cs<=ce) {
			for(int i=cs;i<=ce;i++) {
				ret.add(new Integer(matrix[rs][i]));
			}
			rs++;
		    if(ce>=cs) {
				for(int i=rs;i<=re;i++) {
					ret.add(new Integer(matrix[i][ce]));
				}
		    }
			ce--;
		    if(rs<=re) {
				for(int i=ce;i>=cs;i--) {
					ret.add(new Integer(matrix[re][i]));
				}
		    }
			re--;
		    if(cs<=ce) {
				for(int i=re;i>=rs;i--) {
					ret.add(new Integer(matrix[i][cs]));
				}
		    }
			cs++;
		}

		return ret;
	}
}
