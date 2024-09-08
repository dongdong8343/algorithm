import java.util.*;
import java.io.*;
public class BaekjoonRe2302_2 {
    static int n, m;
    static int[] v = new int[44];
    static int[] dp = new int[44];
    static int go(int here){
        if(here >= n) return 1;
        if(dp[here] != 0) return dp[here];
        if(v[here] == 1) return dp[here] = go(here + 1);
        if(v[here + 1] == 1) return dp[here] = go(here + 2);
        return dp[here] = go(here + 1) + go(here + 2);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            int x = Integer.parseInt(br.readLine());
            v[x] = 1;
        }
        System.out.println(go(1));
    }
}