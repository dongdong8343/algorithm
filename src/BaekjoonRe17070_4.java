import java.util.*;
import java.io.*;
public class BaekjoonRe17070_4 {
    static int n, ret = 0;
    static int[][] a = new int[20][20];
    static int[][][] dp = new int[20][20][3];
    static boolean check(int d, int y, int x){
        if(d == 0 || d == 1){
            return a[y][x] == 0;
        }else{
            return a[y][x] == 0 && a[y - 1][x] == 0 && a[y][x - 1] == 0;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][2][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(check(0, i, j + 1)) dp[i][j + 1][0] += dp[i][j][0];
                if(check(2, i + 1, j + 1)) dp[i + 1][j + 1][2] += dp[i][j][0];

                if(check(1, i + 1, j)) dp[i + 1][j][1] += dp[i][j][1];
                if(check(2, i + 1, j + 1)) dp[i + 1][j + 1][2] += dp[i][j][1];

                if(check(0, i, j + 1)) dp[i][j + 1][0] += dp[i][j][2];
                if(check(1, i + 1, j)) dp[i + 1][j][1] += dp[i][j][2];
                if(check(2, i + 1, j + 1)) dp[i + 1][j + 1][2] += dp[i][j][2];
            }
        }
        ret = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        System.out.println(ret);
    }
}