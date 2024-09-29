import java.util.*;
import java.io.*;
public class BaekjoonRe2342_4 {
    static int idx = 0;
    static int[] a = new int[100004];
    static int[][][] dp = new int[100004][8][8];
    static int go(int here, int l, int r){
        if(here == idx) return 0;
        if(dp[here][l][r] != 987654321) return dp[here][l][r];
        dp[here][l][r] = Math.min(dp[here][l][r], go(here + 1, a[here], r) + move(l, a[here]));
        dp[here][l][r] = Math.min(dp[here][l][r], go(here + 1, l, a[here]) + move(r, a[here]));
        return dp[here][l][r];
    }
    static int move(int from, int to){
        if(from == 0) return 2;
        if(from == to) return 1;
        if(Math.abs(from - to) == 2) return 4;
        return 3;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(true){
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) break;
            a[idx++] = x;
        }
        for(int[][] m1 : dp){
            for(int[] m2 : m1){
                Arrays.fill(m2, 987654321);
            }
        }
        System.out.println(go(0, 0, 0));
    }
}