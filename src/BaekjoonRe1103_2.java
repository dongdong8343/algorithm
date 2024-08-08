import java.util.*;
import java.io.*;
public class BaekjoonRe1103_2 {
    static int n, m;
    static String[][] a = new String[54][54];
    static int[][] v = new int[54][54];
    static int[][] dp = new int[54][54];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int go(int[][] v, int y, int x){
        if(dp[y][x] != 0) return dp[y][x];
        int num = Integer.parseInt(a[y][x]);
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i] * num;
            int nx = x + dx[i] * num;
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx].equals("H")) continue;
            if(v[ny][nx] == 1) {
                System.out.println(-1);
                System.exit(0);
            }
            v[ny][nx] = 1;
            dp[y][x] = Math.max(dp[y][x], go(v, ny, nx) + 1);
            v[ny][nx] = 0;
        }
        return dp[y][x];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                a[i][j] = String.valueOf(s.charAt(j));
            }
        }
        v[0][0] = 1;
        System.out.println(go(v, 0, 0) + 1);
    }
}