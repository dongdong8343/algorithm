import java.io.*;
import java.util.*;

public class Baekjoon2293_2 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        int[] a = new int[n + 1];

        dp[0] = 1;
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());

            for(int j = a[i]; j <= k; j++){
                dp[j] = dp[j - a[i]] + dp[j];
            }
        }

        System.out.println(dp[k]);
    }
}