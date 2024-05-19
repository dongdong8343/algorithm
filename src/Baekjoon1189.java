import java.util.*;
import java.io.*;
public class Baekjoon1189 {
    static int n, m, k, ret = 0;
    static char[][] map = new char[9][9];
    static int[][] visited = new int[9][9];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static void go(int y, int x, int cnt){
        if(cnt > k) return;
        if(cnt == k && y == 0 && x == m - 1){
            ret++;
            return;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] != 0 || map[ny][nx] == 'T') continue;
            visited[ny][nx] = 1;
            go(ny, nx, cnt + 1);
            visited[ny][nx] = 0;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
            }
        }
        visited[n - 1][0] = 1;
        go(n - 1, 0, 1);
        System.out.println(ret);
    }
}