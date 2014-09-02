package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/26/13
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddBinary {
	public String addBinary(String a,String b) {
		if(a==""|| b=="") {
			return a==null?b:a;
		}
		String ret= new String();
		int c=0;
		int ai=a.length()-1,bi=b.length()-1;

		while(ai-->=0&& bi-->=0) {
			if(a.charAt(ai)=='1') {
				if(a.charAt(ai)==b.charAt(bi)) {
					if(c==1) {
						ret+='1';
					}else {
						ret+='0';
					}
					c=1;
				}else {
					if(c==1) {
						ret+='0';
					}else {
						ret+='1';
					}
					c=0;
				}
			}else {
				if(a.charAt(ai)==b.charAt(bi)) {
					if(c==1) {
						ret+='1';
					}else {
						ret+='0';
					}
					c=0;
				}else {
					if(c==1) {
						ret+='1';
					}else {
						ret+='0';
					}
				}
			}

		}
		while(ai>=0) {
			  ret+=a.charAt(ai);
		}

		while(bi>=0) {
			ret+=b.charAt(bi);
		}
		return ret;

	}
}
