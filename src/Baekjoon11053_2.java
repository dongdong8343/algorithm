import java.io.*;
import java.util.*;

public class Baekjoon11053_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ret = 1;

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(a[j] < a[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    ret = Math.max(ret, dp[i]);
                }
            } // for end
        } // for end

        System.out.println(ret);
    }
}
