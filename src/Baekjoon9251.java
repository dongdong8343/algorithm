import java.io.*;
import java.util.*;
public class Baekjoon9251 {
    static String s1, s2;
    static int n1, n2;
    static int[][] dp = new int[1004][1004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s1 = br.readLine();
        s2 = br.readLine();
        n1 = s1.length();
        n2 = s2.length();

        for(int i = 1; i <= n2; i++){
            char c = s2.charAt(i - 1);
            for(int j = 1; j <= n1; j++){
                if (c == s1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[n2][n1]);
    }
}