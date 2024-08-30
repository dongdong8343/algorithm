import java.util.*;
import java.io.*;
public class BaekjoonRe2342_3 {
    static int n = 0;
    static int[] a = new int[100004];
    static int[][][] dp = new int[100004][5][5];
    static int go(int idx, int left, int right){
        if(idx == n) return 0;
        if(dp[idx][left][right] != 987654321) return dp[idx][left][right];
        dp[idx][left][right] = Math.min(dp[idx][left][right], go(idx + 1, a[idx], right) + move(left, a[idx]));
        dp[idx][left][right] = Math.min(dp[idx][left][right], go(idx + 1, left, a[idx]) + move(right, a[idx]));
        return dp[idx][left][right];
    }
    static int move(int from, int to){
        if(from == 0) return 2;
        if(Math.abs(from - to) == 2) return 4;
        if(from == to) return 1;
        else return 3;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(true){
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) break;
            a[n++] = x;
        }
        for(int[][] row : dp){
            for(int[] m : row){
                Arrays.fill(m, 987654321);
            }
        }
        System.out.println(go(0, 0, 0));
    }
}