import java.util.*;
import java.io.*;
public class BaekjoonRe1103_1 {
    static int n, m;
    static char[][] a = new char[54][54];
    static int[][] v = new int[54][54];
    static int[][] dp = new int[54][54];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int go(int y, int x){
        if(dp[x][y] != 0) return dp[x][y];
        int num = Integer.parseInt(String.valueOf(a[y][x]));
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i] * num;
            int ny = y + dy[i] * num;
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == 'H') continue;
            if(v[ny][nx] != 0){
                System.out.println(-1);
                System.exit(0);
            }
            v[ny][nx] = 1;
            dp[x][y] = Math.max(dp[x][y], go(ny, nx) + 1);
            v[ny][nx] = 0;
        }
        return dp[x][y];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                a[i][j] = s.charAt(j);
            }
        }
        System.out.println(go(0, 0) + 1);
    }
}