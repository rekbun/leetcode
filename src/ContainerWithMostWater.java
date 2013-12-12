/*
http://oj.leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if(height.length==0) {
			return 0;
		}

		int max=0;
		int i=0;
		int j=height.length-1;
		while(i<j) {
			if(Math.abs(Math.min(height[i],height[j])*(j-i))>max) {
				max=Math.abs(Math.min(height[i],height[j])*(j-i));
			}
			if(height[i]>height[j]) {
				j--;
			}else {
				i++;
			}

		}

		return max;
	}
}
