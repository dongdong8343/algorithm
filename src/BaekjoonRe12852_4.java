import java.util.*;
import java.io.*;
public class BaekjoonRe12852_4 {
    static int n;
    static int[] dp = new int[1000004];
    static void go(int x){
        System.out.print(x + " ");
        if(x % 3 == 0 && dp[x / 3] + 1 == dp[x]) go(x / 3);
        else if(x % 2 == 0 && dp[x / 2] + 1 == dp[x]) go(x / 2);
        else if(x >= 2 && dp[x - 1] + 1 == dp[x]) go(x - 1);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Arrays.fill(dp, 987654321);
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }
        System.out.println(dp[n]);
        go(n);
    }
}