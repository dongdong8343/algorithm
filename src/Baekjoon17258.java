import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon17258 {
    static int n, m, k, t, s, e;
    static int[] a = new int[304];
    static int[][] dp = new int[304][304];
    static List<Point> v = new ArrayList<>();
    static int go(int here, int num, int prev){
        if(here == v.size()) return 0;
        if(dp[here][num] != 0) return dp[here][num];
        int cost = Math.max(0, t - v.get(here).y);
        int real_cost = (prev >= cost) ? 0 : cost - prev;
        if(num - real_cost >= 0)
            return dp[here][num] = Math.max(go(here + 1, num - real_cost, cost) + v.get(here).x, go(here + 1, num, 0));
        else return dp[here][num] = go(here + 1, num, 0);
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
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            for(int j = s; j < e; j++){
                a[j] = Math.min(t, ++a[j]);
            }
        }
        int temp = a[1];
        int cnt = 1;
        for(int i = 2; i <= n; i++){
            if(temp != a[i]){
                v.add(new Point(cnt, temp));
                cnt = 0;
                temp = a[i];
            }
            cnt++;
        }
        v.add(new Point(cnt, temp));
        System.out.println(go(0, k, 0));
    }
}