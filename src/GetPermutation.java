import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/26/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetPermutation {
	public String getPermutation(int n,int k) {
		int f=1;
		ArrayList<Integer> num= new ArrayList<Integer>();
		for(int i=1;i<=n;i++) {
			num.add(i);
			f=f*i;
		}
		String ret=new String();
		for(int i=n;i>=1;i--) {
			f=f/i;
			int q=(k-1)/f;
			k=k-f*q;
			ret+=('0'+num.get(q));
			num.remove(q);
		}
		return ret;
	}
}
