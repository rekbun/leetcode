package leetcodeagain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * Example 1:
 * Input:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Output:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Example 2:
 * Input:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * Output:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * Note:
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public final class Problem542 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})));
        System.out.println(Arrays.deepToString(solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
        System.out.println(Arrays.deepToString(solution.updateMatrix(new int[][]{{0}, {0}, {0}, {0}, {0}})));
        System.out.println(Arrays.deepToString(solution.updateMatrix(new int[][]{{0}})));
        System.out.println(Arrays.deepToString(solution.updateMatrix(new int[][]
                {
                        {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                        {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}})));
    }
}

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] output = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    output[i][j] = 0;
                } else {
                    output[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int cnt=0;
        boolean isTrue=false;
        while(true) {
            cnt++;
            isTrue=true;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {

                    int x = Math.min(Math.min(j < matrix[i].length - 1 ? output[i][j + 1] : Integer.MAX_VALUE, j > 0 ? output[i][j - 1] : Integer.MAX_VALUE), Math.min(i > 0 ? output[i - 1][j] : Integer.MAX_VALUE, i < matrix.length - 1 ? output[i + 1][j] : Integer.MAX_VALUE));
                    if (x!=Integer.MAX_VALUE && x+1 <output[i][j]) {
                        output[i][j] = x+1;
                        isTrue=false;
                    }
                }
            }
            if(isTrue) {

                break;
            }
        }
        System.out.println(cnt);
        return output;
    }
}