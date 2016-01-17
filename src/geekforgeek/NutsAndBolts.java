package geekforgeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NutsAndBolts {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] nuts = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] bolts = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        solve(nuts, bolts, 0, 4);
        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }

    private static void solve(int[] nuts, int[] bolts, int s, int e) {
        if (s >= e) {
            return;
        }
        swap(bolts, find(nuts[e], bolts, s, e), e);
        int nb = partition(nuts[e], bolts, s, e);
        swap(nuts, find(bolts[nb], nuts, s, e), e);
        int bn = partition(bolts[nb], nuts, s, e);
        solve(nuts, bolts, s, nb - 1);
        solve(nuts, bolts, nb + 1, e);
    }

    private static int swap(int[] bolts, int i, int e) {
        int sfs = bolts[i];
        bolts[i] = bolts[e];
        bolts[e] = sfs;
        return e;
    }

    private static int find(int nut, int[] bolts, int s, int e) {
        for (int i = s; i <= e; i++) {
            if (bolts[i] == nut) {
                return i;
            }
        }
        return s - 1;
    }

    private static int partition(int nut, int[] bolts, int s, int e) {

        int i = s;
        int x = s - 1;
        while (i <= e) {
            if (bolts[i] < nut) {
                int swap = bolts[++x];
                bolts[x] = bolts[i];
                bolts[i] = swap;
            }
            i++;
        }

        swap(bolts, ++x, e);
        return x;
    }
}
