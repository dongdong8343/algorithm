import java.io.*;
import java.util.*;
public class Baekjoon1103 {
    static int n, m, ret = 0;
    static char[][] a = new char[54][54];
    static int[][] dp = new int[54][54];
    static int[][] d = new int[54][54];
    static boolean no = false;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int go(int y, int x){
        if(y >= n || x >= m || y < 0 || x < 0 || a[y][x] == 'H'){
            return 0;
        }
        if(dp[y][x] == 1) {
            System.out.println(-1);
            System.exit(0);
        }
        if(d[y][x] != 0) return d[y][x];
        int num = Integer.parseInt(String.valueOf(a[y][x]));
        dp[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i] * num;
            int nx = x + dx[i] * num;
            d[y][x] = Math.max(d[y][x], go(ny, nx) + 1);
        }
        dp[y][x] = 0;
        return d[y][x];
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
        System.out.println(go(0, 0));
    }
}