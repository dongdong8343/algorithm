import java.util.*;
import java.io.*;
public class Baekjoon2342 {
    static int i = 0;
    static int[] a = new int[100004];
    static int[][][] dp = new int[5][5][100004];
    static int check(int from, int to){
        if(from == 0) return 2;
        if(from == to) return 1;
        if(Math.abs(from - to) == 2) return 4;
        else return 3;
    }
    static int go(int idx, int y, int x){
        if(idx == i) return 0;
        if(dp[y][x][idx] != -1) return dp[y][x][idx];

        int left = go(idx + 1, a[idx], x) + check(y, a[idx]);
        int right = go(idx + 1, y, a[idx]) + check(x, a[idx]);

        return dp[y][x][idx] = Math.min(left, right);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(true) {
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) break;
            a[i++] = x;
        }
        for(int m1[][] : dp){
            for(int m2[] : m1) Arrays.fill(m2, -1);
        }
        System.out.println(go(0, 0, 0));
    }
}