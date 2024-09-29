import java.io.*;
import java.util.*;
public class BaekjoonRe1480_4 {
    static int n, m, c;
    static int[] a = new int[16];
    static int[][][] dp = new int[(1 << 16)][14][24];
    static int go(int v, int idx, int capa){
        if(idx >= m) return 0;
        if(dp[v][idx][capa] != -987654321) return dp[v][idx][capa];
        dp[v][idx][capa] = Math.max(dp[v][idx][capa], go(v, idx + 1, c));
        for(int i = 0; i < n; i++){
            if((v & (1 << i)) != 0 || capa - a[i] < 0) continue;
            dp[v][idx][capa] = Math.max(dp[v][idx][capa], go((v | (1 << i)), idx, capa - a[i]) + 1);
            dp[v][idx][capa] = Math.max(dp[v][idx][capa], go(v, idx, capa));
        }
        return dp[v][idx][capa];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int[][] m1 : dp){
            for(int[] m2 : m1){
                Arrays.fill(m2, -987654321);
            }
        }
        System.out.println(go(0, 0, c));
    }
}