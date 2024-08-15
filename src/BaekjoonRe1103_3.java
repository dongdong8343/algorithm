import java.util.*;
import java.io.*;
public class BaekjoonRe1103_3 {
    static int n, m;
    static char[][] a = new char[54][54];
    static int[][] v = new int[54][54];
    static int[][] dp = new int[54][54];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int go(int y, int x){
        if(y < 0 || x < 0 || y >= n || x >= m || a[y][x] == 'H'){
            return 0;
        }
        if(v[y][x] == 1) {
            System.out.println(-1);
            System.exit(0);
        }
        if(dp[y][x] != -987654321) return dp[y][x];
        v[y][x] = 1;
        int temp = Integer.parseInt(String.valueOf(a[y][x]));
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i] * temp;
            int nx = x + dx[i] * temp;
            dp[y][x] = Math.max(dp[y][x], (go(ny, nx) + 1));
        }
        v[y][x] = 0;
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
                a[i][j] = s.charAt(j);
            }
        }
        for(int[] row : dp) Arrays.fill(row, -987654321);
        int temp= go(0, 0);
        System.out.println(temp);
    }
}