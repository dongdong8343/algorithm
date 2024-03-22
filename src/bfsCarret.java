import java.awt.*;
import java.util.*;
import java.io.*;
public class bfsCarret {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int sx, sy, ex, ey, n, m;
    static int[][] map = new int[104][104];
    static int[][] visited = new int[104][104];
    static void go(int y, int x){
        visited[y][x] = 1;
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x, y));
        while(!q.isEmpty()){
            int bx = q.peek().x;
            int by = q.peek().y;
            if(bx == ex && by == ey) return;
            q.poll();
            for(int i = 0; i < 4; i++){
                int nx = bx + dx[i];
                int ny = by + dy[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                if(visited[ny][nx] == 0 && map[ny][nx] == 1){
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

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(sy, sx);

        System.out.println(visited[ey][ex]);

    }
}
