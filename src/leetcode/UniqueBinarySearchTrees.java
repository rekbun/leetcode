package leetcode;

/*
http://oj.leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		long numerator=binomial(2*n,n);
		return (int)((numerator)/(n+1));
	}

	private long binomial(int n,int x) {
		int ret=n;
		for(int i=2;i<=x;i++) {
			ret*=(n-i+1);
			ret/=i;
		}
		return ret;
	}
}
