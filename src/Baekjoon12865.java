import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon12865 {
    static int n, k;
    static List<Point> li = new ArrayList<>();
    static int[] dp = new int[100004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            li.add(new Point(x, y));
        }
        Collections.sort(li, (o1, o2) -> {
            return o1.x - o2.x;
        });
        for(Point p : li){
            for(int i = k; i >= p.x; i--){
                dp[i] = Math.max(dp[i], dp[i - p.x] + p.y);
            }
        }
        System.out.println(dp[k]);
    }
}