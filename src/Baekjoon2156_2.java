import java.io.*;
import java.util.*;

public class Baekjoon2156_2 {
    static int[] a = new int[10004];
    static int[][] dp = new int[3][10004];
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 3; i++) Arrays.fill(dp[i], -987654321);

        System.out.println(go(0, 0));
    }

    static int go(int idx, int now) {
        if (now == 3) return -987654321;
        if(idx >= n) return 0;
        if (dp[now][idx] != -987654321) return dp[now][idx];

        dp[now][idx] = Math.max(a[idx] + go(idx + 1, now + 1), dp[now][idx]);
        dp[now][idx] = Math.max(go(idx + 1, 0), dp[now][idx]);

        return dp[now][idx];
    }
}