import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe2589 {
    static int n, m, ret;
    static char[][] map = new char[54][54];
    static int[][] visited = new int[54][54];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static void solve(int y, int x){
        visited = new int[54][54];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[y][x] = 1;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 'W' || visited[ny][nx] != 0) continue;
                visited[ny][nx] = visited[p.y][p.x] + 1;
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
            for(int j = 0; j < s.length(); j++){
                map[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'L')
                    solve(i, j);
            }
        }
        System.out.println(ret - 1);
    }
}