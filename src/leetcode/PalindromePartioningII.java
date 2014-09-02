package leetcode;

/*
http://oj.leetcode.com/problems/palindrome-partitioning-ii/
 */
public class PalindromePartioningII {
	public int minCut(String s) {
		if(s.length()==0) {
			return 0;
		}

		int [][] dp=new int[s.length()][s.length()];
		boolean [][] isPalindrome=new boolean[s.length()][s.length()];

		findPalindrome(s,isPalindrome);

		for(int i=0;i<s.length();i++) {
			if(i==0) {
				dp[0][0]=0;
				continue;
			}
			dp[0][i]=Integer.MAX_VALUE;
			for(int len=1;len<=i+1;len++) {
				if(isPalindrome[i-len+1][i]) {
					if(i-len>=0) {
						dp[0][i]=Math.min(dp[0][i],1+dp[0][i-len]);
					}else {
						dp[0][i]=0;
					}

				}
			}
		}
		return dp[0][s.length()-1];
	}

	private void findPalindrome(String s,boolean[][] isPalindrome) {
		for(int len=1;len<=s.length();len++) {
			for(int i=0;i<s.length()-len+1;i++) {
				int j=i+len-1;
				if(len==1) {
					isPalindrome[i][j]=true;
				}else if(len==2) {
					if(s.charAt(i)==s.charAt(j)) {
						isPalindrome[i][j]=true;
					}else {
						isPalindrome[i][j]=false;
					}
				}else {
					if(s.charAt(i)==s.charAt(j) && isPalindrome[i+1][j-1]) {
						isPalindrome[i][j]=true;
					}else {
						isPalindrome[i][j]=false;
					}
				}
			}
		}
	}
}
