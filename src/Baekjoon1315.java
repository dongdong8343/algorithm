import java.util.*;
import java.io.*;
public class Baekjoon1315 {
    static class Q{
        int x, y, c;
        Q(int x, int y, int c){
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    static int n;
    static Q[] a = new Q[54];
    static int[][] dp = new int[1004][1004];
    static boolean[] visited = new boolean[54];
    static int go(int STR, int INT){
        if(dp[STR][INT] != -1) return dp[STR][INT];
        dp[STR][INT] = 0;
        int pnt = 0;
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(a[i].x <= STR || a[i].y <= INT){
                dp[STR][INT]++;
                if(!visited[i]){
                    visited[i] = true;
                    pnt += a[i].c;
                    li.add(i);
                }
            }
        }
        for(int i = 0; i <= pnt; i++){
            int ns = Math.min(1000, STR + i);
            int ni = Math.min(1000, INT + pnt - i);
            dp[STR][INT] = Math.max(dp[STR][INT], go(ns, ni));
        }
        for(int i : li) visited[i] = false;
        return dp[STR][INT];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            a[i] = new Q(x, y, c);
        }
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(go(1, 1));
    }
}