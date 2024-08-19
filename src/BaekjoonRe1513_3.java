import java.util.*;
import java.io.*;
public class BaekjoonRe1513_3 {
    static int n, m, c;
    static int[][] a = new int[54][54];
    static int[][][][] dp = new int[54][54][54][54];
    static int go(int y, int x, int cnt, int v){
        if(y == n && x == m){
            if(cnt == 0 && a[n][m] == 0) return 1;
            if(cnt == 1 && a[n][m] > v) return 1;
            return 0;
        }
        if(y > n || x > m || cnt < 0) return 0;
        if(dp[cnt][y][x][v] != -1) return dp[cnt][y][x][v];
        dp[cnt][y][x][v] = 0;
        if(a[y][x] == 0)
            dp[cnt][y][x][v] = (go(y + 1, x, cnt, v) + go(y, x + 1, cnt, v)) % 1000007;
        else if(a[y][x] > v)
            dp[cnt][y][x][v] = (go(y + 1, x, cnt - 1, a[y][x]) + go(y, x + 1, cnt - 1, a[y][x])) % 1000007;

        return dp[cnt][y][x][v];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= c; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            a[y][x] = i;
        }
        for(int[][][] m1 : dp){
            for(int[][] m2 : m1){
                for(int[] m3 : m2){
                    Arrays.fill(m3, -1);
                }
            }
        }
        for(int i = 0; i <= c; i++){
            System.out.print(go(1, 1, i, 0) + " ");
        }
    }
}