import java.util.*;
import java.io.*;
public class BaekjoonRe1509_3 {
    static int n;
    static boolean[][] dp = new boolean[2504][2504];
    static int[] ret = new int[2504];
    static int go(int here){
        if(here >= n) return 0;
        if(ret[here] != 987654321) return ret[here];
        for(int i = 1; i <= n; i++){
            if(here + i > n) break;
            if(dp[here][i]){
                ret[here] = Math.min(ret[here], go(here + i) + 1);
            }
        }
        return ret[here];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = s.length();
        for(int i = 0; i < n; i++) dp[i][1] = true;
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)) dp[i][2] = true;
        }
        for(int size = 3; size <= n; size++){
            for(int i = 0; i + size <= n; i++){
                if(s.charAt(i) == s.charAt(i + size - 1) && dp[i + 1][size - 2]) dp[i][size] = true;
            }
        }
        Arrays.fill(ret, 987654321);
        System.out.println(go(0));
    }
}