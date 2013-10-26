/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/26/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class GetPermutation {
	public String getPermutation(int n,int k) {
		int x=1;
		int i=1;
		while(x<k) {
			x*=++i;
		}
		if(x<n) {

		}
	}
}
