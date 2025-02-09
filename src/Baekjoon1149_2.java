import java.io.*;
import java.util.*;

public class Baekjoon1149_2 {
    static final int R = 0, G = 1, B = 2;
    static int ret = 987654321, n;
    static int[][] a = new int[1004][10];
    static int[][] dp = new int[1004][10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                a[i][j] = Integer.parseInt(st[j]);
            }
        }

        dp[0][R] = a[0][R];
        dp[0][G] = a[0][G];
        dp[0][B] = a[0][B];

        for (int i = 1; i < n; i++) {
            dp[i][R] = Math.min(a[i][R] + dp[i - 1][G], a[i][R] + dp[i - 1][B]);
            dp[i][G] = Math.min(a[i][G] + dp[i - 1][R], a[i][G] + dp[i - 1][B]);
            dp[i][B] = Math.min(a[i][B] + dp[i - 1][R], a[i][B] + dp[i - 1][G]);
        }

        for (int i = 0; i < 3; i++) {
            if(ret > dp[n - 1][i]) ret = dp[n - 1][i];
        }

        System.out.println(ret);
    }
}