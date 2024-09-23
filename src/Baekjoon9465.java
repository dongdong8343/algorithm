import java.util.*;
import java.io.*;
public class Baekjoon9465 {
    static int tc, n;
    static int[][] a = new int[2][100004];
    static int[][] dp = new int[2][1000004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int[][] a = new int[2][100004];
            dp = new int[2][1000004];
            n = Integer.parseInt(br.readLine());
            for(int i = 0; i < 2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = a[0][0]; dp[1][0] = a[1][0];
            for(int i = 1; i < n; i++){
                if(i >= 2){
                    dp[0][i] = Math.max(a[0][i] + dp[0][i - 2], a[0][i] + dp[1][i - 2]);
                    dp[1][i] = Math.max(a[1][i] + dp[0][i - 2], a[1][i] + dp[1][i - 2]);
                }
                dp[0][i] = Math.max(dp[0][i], a[0][i] + dp[1][i - 1]);
                dp[1][i] = Math.max(dp[1][i], a[1][i] + dp[0][i - 1]);
            }
            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.println(sb);
    }
}