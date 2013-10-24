import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/23/13
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class SolveQueens {
	public boolean canPlace(ArrayList<Integer>list,int x,int n) {
		for(int i=0;i<list.size();i++) {
			if((list.get(i)==n)||(i==x)) {
				return false;
			}
			if(Math.abs(list.get(i)-n)==Math.abs(i-x)) {
				return false;
			}
		}
		return true;
	}
	private void solve(int x,int n,ArrayList<String[]> ret,ArrayList<Integer> list) {
		if(x==n) {
			String[] ans=new String[n];
			for(int i=0;i<n;i++) {
				ans[i]="";
				for(int j=0;j<n;j++) {
					if(j==list.get(i)) {
						ans[i]+='Q';
					}else {
						ans[i]+='.';
					}
				}
			}
			ret.add(ans);
			return;
		}

		for(int i=0;i<n;i++) {
			if(canPlace(list,x,i)) {
				list.add(i);
				solve(x+1,n,ret,list);
				list.remove(list.size()-1);
			}
		}
	}
	public ArrayList<String[]> solveNQueens(int n) {
		if(n==0) {
			return new ArrayList<String[]>();
		}
		ArrayList<String[]> ret=new ArrayList<String[]>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		solve(0,n,ret,list);
		return ret;
	}


}
