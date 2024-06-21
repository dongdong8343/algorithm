import java.util.*;
import java.io.*;
import java.awt.Point;
// 최단 거리 => bfs
// 1초 최대 50
// bfs 돌면서 계속 ret 갱신
public class BaekjoonReReReRe2589 {
    static int n, m, ret = 0;
    static char[][] map = new char[54][54];
    static int[][] visited = new int[54][54];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Point> li = new ArrayList<>();
    static void go(int y, int x){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[y][x] = 1;
        while(!q.isEmpty()){
            Point p = q.poll();
            int hy = p.y;
            int hx = p.x;
            for(int i = 0; i < 4; i++){
                int nx = hx + dx[i];
                int ny = hy + dy[i];
                if(nx < 0 || ny < 0 || ny >= n || nx >= m || visited[ny][nx] != 0 || map[ny][nx] == 'W') continue;
                visited[ny][nx] = visited[hy][hx] + 1;
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
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'L') li.add(new Point(j, i));
            }
        }
        for(Point p : li){
            go(p.y, p.x);
            visited = new int[54][54];
        }
        System.out.println(ret - 1);
    }
}