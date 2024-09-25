import java.util.*;
import java.io.*;
public class Baekjoon1495 {
    static int n, s, m;
    static int[] a = new int[54];
    static int[][] dp = new int[54][1004];
    static int go(int idx, int v){
        if(v < 0 || v > m) return -1;
        if(idx == n) return v;
        if(dp[idx][v] != -987654321) return dp[idx][v];
        return dp[idx][v] = Math.max(go(idx + 1, v + a[idx]), go(idx + 1, v - a[idx]));
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int[] row : dp){
            Arrays.fill(row, -987654321);
        }
        int ret = go(0, s);
        if(ret == -987654321) System.out.println(-1);
        else System.out.println(ret);
    }
}