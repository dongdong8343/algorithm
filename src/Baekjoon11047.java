import java.io.*;
import java.util.*;

public class Baekjoon11047 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 4];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            for(int j = t; j <= k; j++){
                dp[j] = Math.min(dp[j - t] + 1, dp[j]);
            }
        }

        System.out.println(dp[k]);
    }
}