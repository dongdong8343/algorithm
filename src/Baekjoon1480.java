import java.util.*;
import java.io.*;
public class Baekjoon1480 {
    static int n, m, c;
    static int[] a = new int[16];
    static int[][][] dp = new int[16][1 << 14][24];
    static int go(int idx, int v, int capa){
        if(idx == m) return 0;
        if(dp[idx][v][capa] != 0) return dp[idx][v][capa];
        dp[idx][v][capa] = Math.max(dp[idx][v][capa], go(idx + 1, v, c));
        for(int i = 0; i < n; i++){
            boolean before = ((1 << i) & v) != 0;
            boolean can = (capa - a[i]) >= 0;
            if(!before && can)
                dp[idx][v][capa] = Math.max(dp[idx][v][capa], go(idx, v | (1 << i), capa - a[i]) + 1);
        }
        return dp[idx][v][capa];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        System.out.println(go(0, 0, c));
    }
}