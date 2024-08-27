import java.util.*;
import java.io.*;
public class Baekjoon2156 {
    static int n;
    static int[] a = new int[10004];
    static int[][] dp = new int[4][10004];
    static int go(int cnt, int here){
        if(cnt == 3) return -987654321;
        if(here >= n) return 0;
        if(dp[cnt][here] != -987654321) return dp[cnt][here];
        dp[cnt][here] = Math.max(dp[cnt][here], go(cnt + 1, here + 1) + a[here]);
        dp[cnt][here] = Math.max(dp[cnt][here], go(0, here + 1));
        return dp[cnt][here];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(br.readLine());
        for(int[] row : dp){
            Arrays.fill(row, -987654321);
        }
        System.out.println(go(0, 0));
    }
}