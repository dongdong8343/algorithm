import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe2618_3 {
    static int n, w;
    static Point[] a = new Point[1004];
    static int[][] dp = new int[1004][1004];
    static int val(int a, int b){
        if(a == w + 1 || b == w + 1) return 0;
        if(dp[a][b] != 0) return dp[a][b];
        int next = Math.max(a, b) + 1;
        return dp[a][b] = Math.min(val(a, next) + d(b, next), val(next, b) + d(a, next));
    }
    static int d(int from, int to){
        return Math.abs(a[from].x - a[to].x) + Math.abs(a[from].y - a[to].y);
    }
    static void go(){
        int a = 0, b = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < w + 2; i++){
            if(dp[i][b] + d(a, i) < dp[a][i] + d(b, i)){
                sb.append(1).append("\n");
                a = i;
            }else{
                sb.append(2).append("\n");
                b = i;
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
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a[i] = new Point(x, y);
        }
        System.out.println(val(0, 1));
        go();
    }
}