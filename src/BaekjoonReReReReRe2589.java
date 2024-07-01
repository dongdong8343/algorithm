import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReReReReRe2589 {
    static int n, m, ret = 0;
    static int[][] visited;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<Point> q = new LinkedList<>();
    static LinkedList<Point> li = new LinkedList<>();
    static void go(){
        while (!q.isEmpty()) {
            Point p = q.poll();
            int y = p.y;
            int x = p.x;
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] != 0 || map[ny][nx] == 'W') continue;
                visited[ny][nx] = visited[y][x] + 1;
                ret = Math.max(ret, visited[ny][nx]);
                q.add(new Point(nx, ny));
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n + 4][m + 4];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'L') li.add(new Point(j, i));
            }
        }
        for(Point p : li){
            int x = p.x;
            int y = p.y;
            if(map[y][x] == 'L'){
                visited = new int[n + 4][m + 4];
                q.add(new Point(x, y));
                visited[y][x] = 1;
                go();
            }
        }
        System.out.println(ret - 1);
    }
}