import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon1987 {
    static char[][] map = new char[24][24];
    static int[][] visited = new int[24][24];
    static int[] arr = new int[26];
    static int r, c, max = -987654321;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static void solve(int y, int x, int cnt){
        visited[y][x] = 1;
        max = Math.max(max, cnt);
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= r || nx >= c || visited[ny][nx] != 0 || arr[map[ny][nx] - 'A'] == 1) continue;
            arr[map[ny][nx] - 'A'] = 1;
            solve(ny, nx, cnt + 1);
            visited[ny][nx] = 0;
            arr[map[ny][nx] - 'A'] = 0;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = s.charAt(j);
            }
        }
        arr[map[0][0] - 'A'] = 1;
        solve(0, 0, 1);
        System.out.println(max);
    }
}