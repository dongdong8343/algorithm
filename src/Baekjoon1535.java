import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon1535 {
    static int n;
    static int[] p = new int[24];
    static int[] a = new int[24];
    static int[] dp = new int[104];
    static List<Point> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++){
            li.add(new Point(p[i], a[i]));
        }
        Collections.sort(li, (o1, o2) -> {
            return o1.x - o2.x;
        });
        for(Point p : li){
            for(int j = 100; j > p.x; j--){
                dp[j] = Math.max(dp[j], p.y + dp[j - p.x]);
            }
        }
        System.out.println(dp[100]);
    }
}