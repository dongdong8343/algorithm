import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon12852 {
    static int[] dp = new int[1000004];
    static int n;
    static final int INF = 987654321;

    public static void go(int here) {
        System.out.print(here + " ");
        if (here % 3 == 0 && dp[here] == (dp[here / 3] + 1)) go(here / 3);
        else if (here % 2 == 0 && dp[here] == (dp[here / 2] + 1)) go(here / 2);
        else if ((here - 1 >= 1) && (dp[here] == (dp[here - 1] + 1))) go(here - 1);
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(dp, INF);
        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            if (i % 2 == 0) dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
        }
        System.out.println(dp[n]);
        go(n);
        sc.close();
    }
}
