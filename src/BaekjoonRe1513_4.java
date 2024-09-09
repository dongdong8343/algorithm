import java.util.*;
import java.io.*;
public class BaekjoonRe1513_4 {
    static int n, m, c;
    static int[][] a = new int[54][54];
    static int[][][][] dp = new int[54][54][54][54];
    static int go(int y, int x, int prev, int cnt){
        if(y > n || x > m) return 0;
        if(y == n && x == m){
            if(cnt == 1) return prev < a[y][x] ? 1 : 0;
            if(cnt == 0 && a[y][x] == 0) return 1;
            return 0;
        }
        if(cnt < 0) return 0;
        if(dp[y][x][cnt][prev] != -1) return dp[y][x][cnt][prev];
        dp[y][x][cnt][prev] = 0;
        if(a[y][x] == 0)
            dp[y][x][cnt][prev] = (go(y, x + 1, prev, cnt) + go(y + 1, x, prev, cnt)) % 1000007;
        else if(a[y][x] > prev)
            dp[y][x][cnt][prev] = (go(y, x + 1, a[y][x], cnt - 1) + go(y + 1, x, a[y][x], cnt - 1)) % 1000007;
        return dp[y][x][cnt][prev];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= c; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            a[y][x] = i;
        }
        for(int[][][] m1 : dp){
            for(int[][] m2 : m1) {
                for(int[] m3 : m2) {
                    Arrays.fill(m3, -1);
                }
            }
        }
        for(int i = 0; i <= c; i++){
            sb.append(go(1, 1, 0, i)).append(" ");
        }
        System.out.println(sb);
    }
}