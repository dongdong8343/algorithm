import java.util.*;
import java.io.*;
public class BaekjoonRe2342_2 {
    static int n = 0;
    static int[] a = new int[100004];
    static int[][][] dp = new int[100004][5][5];
    static int move(int from, int to){
        if(from == 0) return 2;
        if(from == to) return 1;
        if(Math.abs(from - to) == 2) return 4;
        else return 3;
    }
    static int go(int idx, int left, int right){
        if(idx == n) return 0;
        if(dp[idx][left][right] != 987654321) return dp[idx][left][right];
        dp[idx][left][right] = 0;
        int l = move(left, a[idx]) + go(idx + 1, a[idx], right);
        int r = move(right, a[idx]) + go(idx + 1, left, a[idx]);
        dp[idx][left][right] = Math.min(l, r);
        return dp[idx][left][right];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        while(true){
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) break;
            a[n++] = x;
        }
        for(int[][] m1 : dp){
            for(int[] m2 : m1){
                Arrays.fill(m2, 987654321);
            }
        }
        System.out.println(go(0, 0, 0));
    }
}