/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/27/13
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sqrt {
	public int sqrt(int x) {
		if(x<0) {
			return -1;
		}
		int n=1;
		int s=1;
		int e=46341;
		while(s<e) {
			int mid=(s+e)/2;
			if(mid*mid==x ||(mid*mid<x&&(mid+1)*(mid+1)>x)) {
				return mid;
			}else if(mid*mid>x ) {
				e--;
			}else {
				s++;
			}
		}
		return e;
	}

}
