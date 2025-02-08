import java.io.*;
import java.util.*;

public class Baekjoon1932_2 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ret = -987654321;

        int[][] a = new int[504][504];
        int[][] dp = new int[504][504];

        for(int i = 0; i < n; i++){
            String[] st = br.readLine().split(" ");
            for(int j = 0; j <= i; j++){
                a[i][j] = Integer.parseInt(st[j]);
            }
        }

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -987654321);
        }

        dp[0][0] = a[0][0];
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j != i) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + a[i][j]);
                if(j != 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + a[i][j]);
            }
        }

        for(int i = 0; i < n; i++){
            ret = Math.max(ret, dp[n - 1][i]);
        }

        System.out.println(ret);

    }
}