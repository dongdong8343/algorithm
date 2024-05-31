import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReRe2589 {
    static int n, m, ret = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static char[][] map = new char[54][54];
    static int[][] visited = new int[54][54];
    static void bfs(int y, int x){
        visited[y][x] = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || ny >= n || nx >= m || visited[ny][nx] != 0) continue;
                if(map[ny][nx] == 'L'){
                    visited[ny][nx] = visited[p.y][p.x] + 1;
                    q.add(new Point(nx, ny));
                    ret = Math.max(ret, visited[ny][nx]);
                }
            }
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
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'L'){
                    visited = new int[54][54];
                    bfs(i, j);
                }
            }
        }
        System.out.println(ret - 1);
    }
}
