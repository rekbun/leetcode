package geekforgeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] inp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lis = new int[inp.length];
        lis[0] = 1;
        for (int i = 1; i < inp.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (inp[i] >= inp[j]) {
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        System.out.print(Arrays.stream(lis).max().getAsInt());
    }
}
