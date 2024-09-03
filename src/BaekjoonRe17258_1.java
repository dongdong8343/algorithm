import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe17258_1 {
    static int n, m, k, t;
    static int[] a = new int[304];
    static List<Point> li = new ArrayList<>();
    static int[][] dp = new int[304][304];
    static int go(int here, int prev, int capa){
        if(here == li.size()) return 0;
        if(dp[here][capa] != 0) return dp[here][capa];
        int cost = Math.max(0, t - li.get(here).y);
        int rc = (prev >= cost) ? 0 : cost - prev;
        if(capa - rc >= 0){
            dp[here][capa] = Math.max(go(here + 1, cost, capa - rc) + li.get(here).x, go(here + 1, 0, capa));
        }
        else{
            dp[here][capa] = go(here + 1, 0, capa);
        }
        return dp[here][capa];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for(int j = s; j < e; j++) a[j] = Math.min(t, ++a[j]);
        }
        int temp = a[1];
        int cnt = 1;
        for(int i = 2; i <= n; i++){
            if(temp != a[i]){
                li.add(new Point(cnt, temp));
                cnt = 0;
                temp = a[i];
            }
            cnt++;
        }
        li.add(new Point(cnt, temp));
        System.out.println(go(0, 0, k));
    }
}