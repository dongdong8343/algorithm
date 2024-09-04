import java.util.*;
import java.io.*;
public class Baekjoon2302 {
    static int n, m;
    static int[] a = new int[44];
    static int[] dp = new int[44];
    static int go(int here){
        if(here >= n - 1) return 1;
        if(a[here] == 1) return go(here + 1);
        if(dp[here] != -1) return dp[here];
        dp[here] = 0;
        if(a[here + 1] != 1) dp[here] += go(here + 1) + go(here + 2);
        else dp[here] += go(here + 1);
        return dp[here];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            int x = Integer.parseInt(br.readLine());
            a[x - 1] = 1;
        }
        Arrays.fill(dp, -1);
        System.out.println(go(0));
    }
}