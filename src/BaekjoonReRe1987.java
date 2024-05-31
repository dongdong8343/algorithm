import java.util.*;
import java.io.*;
public class BaekjoonReRe1987 {
    static int n, m, max = -987654321;
    static char[][] map = new char[24][24];
    static int[][] visited = new int[24][24];
    static int[] al = new int[26];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static void go(int y, int x, int cnt){
        max = Math.max(max, cnt);
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] == 1 || al[map[ny][nx] - 'A'] == 1) continue;
            visited[ny][nx] = 1;
            al[map[ny][nx] - 'A'] = 1;
            go(ny, nx, cnt + 1);
            visited[ny][nx] = 0;
            al[map[ny][nx] - 'A'] = 0;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
            }
        }
        visited[0][0] = 1;
        al[map[0][0] - 'A'] = 1;
        go(0, 0, 1);
        System.out.println(max);
    }
}