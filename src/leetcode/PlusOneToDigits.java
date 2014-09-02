package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/26/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlusOneToDigits {
	public int[] plusOne(int[] digits) {
		if(digits.length==0) {
			return new int[]{};
		}
		int cnt=0;
		for(int i=0;i<digits.length;i++) {
			if(digits[i]==9) {
				cnt++;
				continue;
			}else {
				break;
			}
		}
		int[] ret;
		if(cnt==digits.length) {
			ret=new int[digits.length+1];
			for(int i=ret.length-1;i>=0;i--) {
				ret[i]=0;
			}
			ret[0]=1;
			return ret;
		}else {
			ret=new int[digits.length];
		}
		System.arraycopy(digits,0,ret,0,digits.length);
		for(int i=ret.length-1;i>=0;i--) {
			if(ret[i]==9) {
				ret[i]=0;
			}else {
				ret[i]=ret[i]+1;
				break;
			}
		}
		return ret;

	}
}
