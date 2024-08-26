import java.util.*;
import java.io.*;
public class Baekjoon2579 {
    static int n;
    static int[] a = new int[304];
    static int[][] dp = new int[304][5];
    static int go(int here, int cnt){
        if(here > n || cnt == 3) return -987654321;
        if(here == n) return a[here];
        if(dp[here][cnt] != -987654321) return dp[here][cnt];
        dp[here][cnt] = Math.max(dp[here][cnt], go(here + 1, cnt + 1) + a[here]);
        dp[here][cnt] = Math.max(dp[here][cnt], go(here + 2, 1) + a[here]);
        return dp[here][cnt];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) a[i] = Integer.parseInt(br.readLine());
        for(int[] row : dp){
            Arrays.fill(row, -987654321);
        }
        System.out.println(go(0, 0));
    }
}