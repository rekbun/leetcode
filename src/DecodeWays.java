/*
http://oj.leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
	public int numDecodings(String src) {
		if(src.length()==0) {
			return 0;
		}

		int[] dp=new int[src.length()];
		for(int i=0;i<dp.length;i++) {
			dp[i]=-1;
		}
		decodeWaysUtilIterative(src, 0, dp);
		return dp[0];
	}

	private int decodeWaysUtilIterative(String src, int index, int[] dp) {
		for(int i=src.length()-1;i>=0;i--) {
				dp[i]=0;
				if(src.charAt(i)=='0') {
					dp[i]=0;
				}
				if(i+1<src.length()) {
					dp[i]=dp[i+1];
				}
				if(i+2<src.length() && ((src.charAt(i)=='2'&& src.charAt(i+1)<='6')||(src.charAt(i)=='1')) ) {
					dp[i]+=dp[i+2];
				}
		}
		return dp[0];
	}

	private int decodeWaysUtilRecursive(String src, int index, int[] dp) {
		if(index>src.length()) {
			return 0;
		}
		if(index==src.length()) {
			return 1;
		}
		if(dp[index]!=-1) {
			return dp[index];
		}
		if(src.charAt(index)=='0') {
			dp[index]=0;
			return 0;
		}

		dp[index]=decodeWaysUtilRecursive(src, index+1, dp);
		if(index<src.length()-1 && ((src.charAt(index)=='2' && src.charAt(index+1)<'7') ||(src.charAt(index)=='1'))) {
			dp[index]+=decodeWaysUtilRecursive(src, index+2, dp);
		}
		return dp[index];
	}
}
