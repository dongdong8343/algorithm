import java.io.*;
import java.util.*;
public class BaekjoonRe2302_1 {
    static int n, m;
    static int[] a = new int[44];
    static int[] dp = new int[44];
    static int go(int here){
        if(here >= n) return 1;
        if(dp[here] != -1) return dp[here];
        if(a[here] == 1 || here + 1 == n) {
            return go(here + 1);
        }
        if(a[here + 1] != 1){
            dp[here] = go(here + 2) + go(here + 1);
        }else {
            dp[here] = go(here + 2);
        }
        return dp[here];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            int x = Integer.parseInt(br.readLine()) - 1;
            a[x] = 1;
        }
        Arrays.fill(dp, -1);
        System.out.println(go(0));
    }
}