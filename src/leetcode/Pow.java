package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/23/13
 * Time: 8:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Pow {
	public double pow(int x,int n) {
		if(x==0) {
			return 0;
		}

		if(n==0) {
			return 1;
		}
		double  ans=0;
		double y=pow(x,n/2);
		if(n%2==1) {
			ans=x*y*y;
		}else {
			ans=y*y;
		}
		return ans;
	}
}
