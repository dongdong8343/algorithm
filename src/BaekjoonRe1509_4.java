import java.util.*;
import java.io.*;
public class BaekjoonRe1509_4 {
    static String s;
    static boolean[][] dp = new boolean[2504][2504];
    static int[] dp2 = new int[2504];
    static int go(int here){
        if(here == s.length()) return 0;
        if(dp2[here] != 987654321) return dp2[here];
        for(int i = 1; here + i <= s.length(); i++){
            if(dp[here][i]) dp2[here] = Math.min(dp2[here], go(here + i) + 1);
        }
        return dp2[here];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for(int i = 0; i < s.length(); i++) dp[i][1] = true;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)) dp[i][2] = true;
        }
        for(int size = 3; size <= s.length(); size++){
            for(int i = 0; i + size <= s.length(); i++){
                if(s.charAt(i) == s.charAt(i + size - 1) && dp[i + 1][size - 2]) dp[i][size] = true;
            }
        }
        Arrays.fill(dp2, 987654321);
        System.out.println(go(0));
    }
}