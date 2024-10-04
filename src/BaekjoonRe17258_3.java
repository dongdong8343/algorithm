import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe17258_3 {
    static int n, m, k, t, s, e;
    static int[] a = new int[304];
    static int[][] dp = new int[304][304];
    static List<Point> v = new ArrayList<>();
    static int go(int idx, int now, int temp){
        if(idx == v.size()) return 0;
        if(dp[idx][now] != 0) return dp[idx][now];
        int cost = Math.max(0, t - v.get(idx).y);
        int real_cost = (temp >= cost) ? 0 : cost - temp;
        if(now - real_cost >= 0)
            return dp[idx][now] = Math.max(go(idx + 1, now - real_cost, cost) + v.get(idx).x, go(idx + 1, now, 0));
        else return dp[idx][now] = go(idx + 1, now, 0);
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
                a[j] = Math.min(t, a[j] + 1);
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