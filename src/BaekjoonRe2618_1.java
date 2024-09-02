import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe2618_1 {
    static int n, w;
    static Point[] a = new Point[1004];
    static int[][] dp = new int[1004][1004];
    static int go(int p1, int p2){
        if(p1 == w + 1 || p2 == w + 1) return 0;
        if(dp[p1][p2] != 987654321) return dp[p1][p2];
        int next = Math.max(p1, p2) + 1;
        dp[p1][p2] = Math.min(dp[p1][p2], go(next, p2) + d(p1, next));
        dp[p1][p2] = Math.min(dp[p1][p2], go(p1, next) + d(p2, next));
        return dp[p1][p2];
    }
    static int d(int from, int to){
        return Math.abs(a[from].y - a[to].y) + Math.abs(a[from].x - a[to].x);
    }
    static void get(){
        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = 1;
        for(int i = 2; i < w + 2; i++){
            if(dp[p1][i] + d(p2, i) < dp[i][p2] + d(p1, i)) {
                p2 = i;
                sb.append("2").append("\n");
            }else{
                p1 = i;
                sb.append("1").append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());
        a[0] = new Point(1, 1);
        a[1] = new Point(n, n);
        for(int i = 2; i < w + 2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            a[i] = new Point(x, y);
        }
        for(int[] row : dp){
            Arrays.fill(row, 987654321);
        }
        System.out.println(go(0, 1));
        get();
    }
}