import java.util.*;
import java.io.*;
public class Baekjoon17070 {
    static int n, ret = 0;
    static int[][] a = new int[20][20];
    static int[][][] dp = new int[3][20][20];
    static boolean check(int y, int x, int idx){
        if(idx == 0 || idx == 1){
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
        dp[0][1][2] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(check(i, j + 1, 0)) dp[0][i][j + 1] += dp[0][i][j];
                if(check(i + 1, j + 1, 2)) dp[2][i + 1][j + 1] += dp[0][i][j];

                if(check(i + 1, j, 1)) dp[1][i + 1][j] += dp[1][i][j];
                if(check(i + 1, j + 1, 2)) dp[2][i + 1][j + 1] += dp[1][i][j];

                if(check(i, j + 1, 0)) dp[0][i][j + 1] += dp[2][i][j];
                if(check(i + 1, j, 1)) dp[1][i + 1][j] += dp[2][i][j];
                if(check(i + 1, j + 1, 2)) dp[2][i + 1][j + 1] += dp[2][i][j];
            }
        }
        ret = dp[0][n][n]; ret += dp[1][n][n]; ret += dp[2][n][n];
        System.out.println(ret);
    }
}