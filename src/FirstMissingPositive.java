/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/20/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int [] num) {
		if(num==null) {
			return -1;
		}
		for(int i=0;i<num.length;i++) {
			if(num[i]<0 || num[i]>=num.length) {
				continue;
			}else {

				int x;

				while(num[num[i]]!=num[i]) {
				    x=num[num[i]];
					num[num[i]]= num[i];
					num[i]=x;
				}
			}

		}
		for(int i=0;i<num.length;i++) {
			if(num[i]!=i) {
				return i;
			}
		}
		return -1;
	}
}
