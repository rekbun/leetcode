/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/25/13
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if(s==null||s.length()==0) {
			return 0;
		}
		int len=0;
		int lastWordLen=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ') {
				if(len>0) {
					lastWordLen=len;
				}
				len=0;
			}else {
				len++;
			}
		}
		return Math.max(len,lastWordLen);
	}
}
