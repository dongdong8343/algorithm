import java.util.*;
import java.io.*;
public class Baekjoon1904 {
    static int n;
    static int[] dp = new int[1000004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp[1] = 1; dp[2] = 2;
        for(int i = 3; i <= n; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        System.out.println(dp[n]);
    }
}