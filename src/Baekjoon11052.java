import java.io.*;
import java.util.*;

public class Baekjoon11052 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= n; i++){
            int t = Integer.parseInt(st.nextToken());
            for(int j = i; j <= n; j++){
                dp[j] = Math.max(dp[j], dp[j - i] + t);
            }
        }

        System.out.println(dp[n]);
    }
}