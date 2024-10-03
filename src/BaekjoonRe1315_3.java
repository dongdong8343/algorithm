import java.util.*;
import java.io.*;
public class BaekjoonRe1315_3 {
    static class S{
        int x, y, c;
        S(int x, int y, int c){
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    static int n;
    static S[] a = new S[54];
    static int[][] dp = new int[1004][1004];
    static boolean[] v = new boolean[54];
    static int go(int STR, int INT){
        if(dp[STR][INT] != -1) return dp[STR][INT];
        List<Integer> li = new ArrayList<>();
        int p = 0;
        dp[STR][INT] = 0;
        for(int i = 0; i < n; i++){
            if(a[i].x <= STR || a[i].y <= INT){
                dp[STR][INT]++;
                if(!v[i]){
                    v[i] = true;
                    li.add(i);
                    p += a[i].c;
                }
            }
        }
        for(int i = 0; i <= p; i++){
            int ns = Math.min(1000, STR + i);
            int ni = Math.min(1000, INT + p - i);
            dp[STR][INT] = Math.max(dp[STR][INT], go(ns, ni));
        }
        for(int x : li) v[x] = false;
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
            a[i] = new S(x, y, c);
        }
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(go(1, 1));
    }
}