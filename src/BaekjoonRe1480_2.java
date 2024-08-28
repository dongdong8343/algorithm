import java.util.*;
import java.io.*;
public class BaekjoonRe1480_2 {
    static int n, m, c;
    static int[] a = new int[17];
    static int[][][] dp = new int[16][24][1 << 13];
    static int go(int idx, int capa, int v){
        if(idx == m) return 0;
        if(dp[idx][capa][v] != -987654321) return dp[idx][capa][v];
        dp[idx][capa][v] = Math.max(dp[idx][capa][v], go(idx + 1, c, v));
        for(int i = 0; i < n; i++){
            if((v & (1 << i)) != 0) continue;
            if(capa - a[i] < 0) continue;
            dp[idx][capa][v] = Math.max(dp[idx][capa][v], go(idx, capa - a[i], v | (1 << i)) + 1);
        }
        return dp[idx][capa][v];
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
        System.out.println(go(0, c, 0));
    }
}