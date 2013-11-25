/*
http://oj.leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		if (s1.equals("") && s2.equals("") && s3.equals("")) {
			return true;
		}
		if (s1.equals("") || s2.equals("")) {
			return s1.equals("") ? s2.equals(s3) : s1.equals(s3);
		}

		//isInterleaveUtilRecursive(s1,s2,s3,0,0,dp);
		boolean [][] dp= new boolean[s1.length()+1][s2.length()+1];
		dp[s1.length()][s2.length()]=true;
		dp[s1.length()-1][s2.length()]=s1.charAt(s1.length()-1)==s3.charAt(s1.length()+s2.length()-1);
		dp[s1.length()][s2.length()-1]=s2.charAt(s2.length()-1)==s3.charAt(s1.length()+s2.length()-1);
		for(int i=s1.length()-1;i>=0;i--) {
			dp[i][s2.length()]=s1.charAt(i)==s3.charAt(i+s2.length())&&dp[i+1][s2.length()];

		}
		for(int i=s2.length()-1;i>=0;i--) {
			dp[s1.length()][i]=s2.charAt(i)==s3.charAt(i+s1.length())&&dp[s1.length()][i+1];
		}
		for(int i=s1.length()-1;i>=0;i--) {
			for (int j=s2.length()-1;j>=0;j--) {
				dp[i][j]=s1.charAt(i)==s3.charAt(i+j)&&dp[i+1][j];
				dp[i][j]=dp[i][j]||(s2.charAt(j)==s3.charAt(i+j)&&dp[i][j+1]);
			}

		}

		return dp[0][0];
	}
	private int isInterleaveUtilRecursive(String s1, String s2, String s3, int i1, int i2, int[][] dp) {
		if (i1 == dp.length && i2 == dp[0].length) {
			return 1;
		}
		if (i1 >= dp.length || i2 >= dp[0].length) {
			return 0;
		}

		if (dp[i1][i2] != -1) {
			return dp[i1][i2];
		}
		if (s1.charAt(i1) == s3.charAt(i1 + i2)) {
			dp[i1][i2] = isInterleaveUtilRecursive(s1, s2, s3, i1 + 1, i2, dp);
		}
		if (dp[i1][i2] == -1 && (s2.charAt(i2) == s3.charAt(i1 + i2))) {
			dp[i1][i2] = isInterleaveUtilRecursive(s1, s2, s3, i1, i2 + 1, dp);
		}
		return dp[i1][i2];
	}
}