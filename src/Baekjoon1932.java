import java.util.*;
import java.io.*;
public class Baekjoon1932 {
    static int n;
    static int[][] a = new int[504][504];
    static int[][] dp = new int[504][504];
    static int go(int idx, int here){
        if(idx == n) return 0;
        if(dp[idx][here] != -987654321) return dp[idx][here];
        dp[idx][here] = Math.max(dp[idx][here], go(idx + 1, here) + a[idx][here]);
        dp[idx][here] = Math.max(dp[idx][here], go(idx + 1, here + 1) + a[idx][here]);
        return dp[idx][here];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int[] m1 : dp){
            Arrays.fill(m1, -987654321);
        }
        System.out.println(go(0, 0));
    }
}