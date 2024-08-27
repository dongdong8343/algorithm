import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon12865_1 {
    static int n, k, w, v;
    static Point[] a = new Point[104];
    static int[][] dp = new int[104][100004];
    static int go(int idx, int capa){
        if(capa > k) return -987654321;
        if(idx == n) return 0;
        if(dp[idx][capa] != -987654321) return dp[idx][capa];
        dp[idx][capa] = Math.max(dp[idx][capa], go(idx + 1, capa));
        dp[idx][capa] = Math.max(dp[idx][capa], go(idx + 1, capa + a[idx].x) + a[idx].y);
        return dp[idx][capa];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            a[i] = new Point(w, v);
        }
        for(int[] row : dp){
            Arrays.fill(row, -987654321);
        }
        System.out.println(go(0, 0));
    }
}