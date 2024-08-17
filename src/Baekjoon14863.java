import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon14863 {
    static int n, k;
    static Point[] walk = new Point[104];
    static Point[] bike = new Point[104];
    static int[][] dp = new int[104][100004];
    static int go(int idx, int time){
        if(time > k) return -987654321;
        if(idx == n) return 0;
        if(dp[idx][time] != -987654321) return dp[idx][time];
        dp[idx][time] = Math.max(dp[idx][time], go(idx + 1, time + walk[idx].x) + walk[idx].y);
        dp[idx][time] = Math.max(dp[idx][time], go(idx + 1, time + bike[idx].x) + bike[idx].y);
        return dp[idx][time];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            walk[i] = new Point(x, y);
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            bike[i] = new Point(x, y);
        }
        for(int[] row : dp) Arrays.fill(row, -987654321);
        System.out.println(go(0, 0));
    }
}