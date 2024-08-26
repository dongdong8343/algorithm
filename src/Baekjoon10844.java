import java.util.*;
import java.io.*;
public class Baekjoon10844 {
    static int n;
    static long[][] dp = new long[104][14];
    static long go(int idx, int now){
        if(idx == n) return 1;
        if(dp[idx][now] != -1) return dp[idx][now];
        dp[idx][now] = 0;
        for(int i = 0; i < 10; i++){
            if(idx == 0 && i == 0) continue;
            if(idx == 0) dp[idx][now] += go(idx + 1, i) % 1000000000;
            else if(now - 1 == i || now + 1 == i) dp[idx][now] += go(idx + 1, i) % 1000000000;
        }
        return dp[idx][now] % 1000000000;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(go(0, 0));
    }
}