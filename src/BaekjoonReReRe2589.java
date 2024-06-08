import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReReRe2589 {
    static char[][] map = new char[54][54];
    static int[][] visited= new int[54][54];
    static int n, m, max = -987654321;
    static List<Point> li = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static void bfs(int y, int x){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[y][x] = 1;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] != 0) continue;
                if(map[ny][nx] == 'L'){
                    visited[ny][nx] = visited[p.y][p.x] + 1;
                    q.add(new Point(nx, ny));
                    max = Math.max(max, visited[ny][nx]);
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
                if(map[i][j] == 'L') li.add(new Point(j, i));
            }
        }
        for(Point p : li){
            bfs(p.y, p.x);
            visited = new int[54][54];
        }
        System.out.println(max - 1);
    }
}