import java.util.*;
import java.io.*;
public class BaekjoonRe2098_4 {
    static int n;
    static int[][] a = new int[20][20];
    static int[][] dp = new int[1 << 16][20];
    static int go(int v, int here){
        if(v == (1 << n) - 1){
            if(a[here][0] != 0) return a[here][0];
            else return 987654321;
        }
        if(dp[v][here] != -1) return dp[v][here];
        dp[v][here] = 987654321;
        for(int i = 1; i < n; i++){
            if((v & (1 << i)) != 0 || a[here][i] == 0) continue;
            dp[v][here] = Math.min(dp[v][here], go(v | (1 << i), i) + a[here][i]);
        }
        return dp[v][here];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(go(1, 0));
    }
}