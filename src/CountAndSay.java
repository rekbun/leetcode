/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/9/13
 * Time: 9:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class CountAndSay {
	public String countAndSay(int n)  {
		if(n==0) return "";
		String ret="1";
		if(n==1) return ret;
		while(n-->1) {
			String in="";
			for(int i=0;i<ret.length();) {
				int cnt=1;
				while(i+1<ret.length() && ret.charAt(i)==ret.charAt(i+1)) {
					cnt++;
					i++;
				}
				in=in+cnt+ret.charAt(i);
				i++;
			}
			if(in=="") {
				in="11";
			}
			ret=in;
		}
		return  ret;
	}

	/*public static void main(String[] ar) {
		CountAndSay sol = new CountAndSay();
		sol.countAndSay(5);
	}*/
}
