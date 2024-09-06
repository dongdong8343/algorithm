import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe2618_2 {
    static int n, w;
    static List<Point> li = new ArrayList<>();
    static int[][] dp = new int[1004][1004];
    static int go(int p1, int p2){
        if(p1 == li.size() - 1 || p2 == li.size() - 1) return 0;
        if(dp[p1][p2] != 0) return dp[p1][p2];
        int next = Math.max(p1, p2) + 1;
        dp[p1][p2] = Math.min(go(p1, next) + d(p2, next), go(next, p2) + d(p1, next));
        return dp[p1][p2];
    }
    static int d(int from, int to){
        return Math.abs(li.get(from).x - li.get(to).x) + Math.abs(li.get(from).y - li.get(to).y);
    }
    static void police(){
        int p1 = 0;
        int p2 = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < w + 2; i++){
            if(dp[p1][i] + d(p2, i) < dp[i][p2] + d(p1, i)){
                p2 = i;
                sb.append(2).append('\n');
            }
            else{
                p1 = i;
                sb.append(1).append('\n');
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());
        li.add(new Point(1, 1));
        li.add(new Point(n, n));
        for(int i = 0; i < w; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            li.add(new Point(x, y));
        }
        System.out.println(go(0, 1));
        police();
    }
}