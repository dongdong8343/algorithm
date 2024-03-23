import java.io.*;
import java.util.*;
import java.awt.*;
public class Baekjoon2178 {
    static int[][] map = new int[104][104];
    static int[][] visited = new int[104][104];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n;
    static int m;
    static void go(int y, int x){
        visited[y][x] = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        while(!q.isEmpty()){
            int bx = q.peek().x;
            int by = q.peek().y;
            q.poll();
            for(int i = 0; i < 4; i++){
                int nx = bx + dx[i];
                int ny = by + dy[i];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(visited[ny][nx] == 0 && map[ny][nx] != 0){
                    visited[ny][nx] = visited[by][bx] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        go(0, 0);
        System.out.println(visited[n-1][m-1]);
    }
}
