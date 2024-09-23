import java.util.*;
import java.io.*;
public class Baekjoon15988 {
    static int n, tc;
    static long[] dp = new long[1000004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for(int i = 4; i < 1000004; i++){
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000009;
        }
        while(tc-- > 0){
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
    }
}