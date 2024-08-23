import java.util.*;
import java.io.*;
public class Baekjoon9461 {
    static int t;
    static long[] dp = new long[104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp[0] = dp[1] = dp[2] = 1;
        for(int i = 3; i < 100; i++) dp[i] = dp[i - 2] + dp[i - 3];
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n - 1]);
        }
    }
}