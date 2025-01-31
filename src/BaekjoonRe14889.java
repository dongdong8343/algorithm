import java.io.*;
import java.util.*;

public class BaekjoonRe14889 {
    static int n, min = 987654321;
    static int[][] a = new int[24][24];
    static int[] idx;

    static void cal(boolean[] v) {
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            if (v[i]) {
                for (int j = 0; j < n; j++) {
                    if (i != j && v[j]) start += a[i][j];
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (i != j && !v[j]) end += a[i][j];
                }
            }
        }

        min = Math.min(min, Math.abs(start - end));
    }

    static void go(int start, int cnt, boolean[] v) {
        if (cnt == n / 2) {
            cal(v);
            return;
        }
        for (int i = start + 1; i < n; i++) {
            v[i] = true;
            go(i, cnt + 1, v);
            v[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] v = new boolean[24];
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(nums[j]);
            }
        }

        go(-1, 0, v);

        System.out.println(min);
    }
}