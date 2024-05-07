import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon14497 {
    static int n, m, turn = 0, find = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static char[][] map = new char[304][304];
    static int[][] visited;
    static Point p1, p2;
    static void dfs(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny == p2.y && nx == p2.x){
                find = 1;
                return;
            }
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] == 1) continue;
            if(map[ny][nx] == '1'){
                visited[ny][nx] = 1;
                map[ny][nx] = '0';
            }
            else if(map[ny][nx] == '0') {
                dfs(ny, nx);
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;
        p1 = new Point(x, y);
        y = Integer.parseInt(st.nextToken()) - 1;
        x = Integer.parseInt(st.nextToken()) - 1;
        p2 = new Point(x, y);
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
            }
        }
        while(true){
            turn++;
            visited = new int[304][304];
            dfs(p1.y, p1.x);
            if(find == 1){
                System.out.println(turn);
                break;
            }
        }
    }
}