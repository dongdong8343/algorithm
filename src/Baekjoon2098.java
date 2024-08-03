import java.util.*;
import java.io.*;
public class Baekjoon2098 {
    static int n;
    static int[][] w = new int[16][16];
    static int[][] dp = new int[16][1 << 16];
    static int go(int here, int v){
        if(v == (1 << n) - 1){
            return w[here][0] != 0 ? w[here][0] : 987654321;
        }
        if(dp[here][v] != -1) return dp[here][v];
        dp[here][v] = 987654321;
        for(int i = 0; i < n; i++){
            if(w[here][i] == 0) continue;
            if((v & (1 << i)) != 0) continue;
            dp[here][v] = Math.min(dp[here][v], go(i, v | (1 << i)) + w[here][i]);
        }
        return dp[here][v];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int[] row : dp) Arrays.fill(row, -1);
        System.out.println(go(0, 1));
    }
}
