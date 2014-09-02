package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/22/13
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class IsMatch {
	private boolean checkForNull(String s,String p,int si,int pi) {
		if(s=="" || s==null) {
			if(p=="" || p==null) {
				return true;
			}
			for(int i=0;i<p.length();i++) {
				if(p.charAt(i)!='*') {
					return false;
				}
			}
		}
		return false;
	}
	private boolean checkForCompletion(String s,String p,int si,int pi) {
		if(si==s.length()) {
			if(pi==p.length()) {
				return true;
			}
			for(int i=pi;i<p.length();i++) {
				if(p.charAt(i)!='*') {
					return false;
				}
			}
			return true;

		}
		if(pi==p.length()) {
			return false;
		}

		return false;
	}

	private boolean isMatchUtil(String s,String p) {

		int si=0;
		int pi=0;
		int star_p=-1;
		int star_s=-1;
		while(si<s.length()&& pi<p.length()) {
			switch (p.charAt(pi))  {
				case '*' :
					while(pi<p.length() && p.charAt(pi)=='*') {
						pi++;
					}
					if(pi==p.length()) {
						return true;
					}

					star_p=pi;
					star_s=si;
					break;
				default:
					if(p.charAt(pi)=='?'|| p.charAt(pi)==s.charAt(si)) {
						pi++;
						si++;
						if(pi==p.length() && si!=s.length()&& star_p!=-1) {
							pi=star_p;
							si=star_s+1;
							star_s++;
						}
					}else if(star_p!=-1) {
						pi=star_p;
						si=star_s+1;
						star_s++;
					}else {
						return false;
					}
					break;
			}
		}

		return checkForCompletion(s,p,si,pi);
	}

	public boolean isMatch(String s,String p) {
		if(checkForNull(s,p,0,0)) {
			return true;
		}
		return isMatchUtil(s,p);
	}
}
