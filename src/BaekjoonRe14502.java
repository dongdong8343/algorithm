import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;
public class BaekjoonRe14502 {
    static int[][] map = new int[12][12];
    static int[][] visited = new int[12][12];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    static List<Point> empty = new ArrayList<>();
    static List<Point> wall = new ArrayList<>();
    static List<Point> virus = new ArrayList<>();
    static void dfs(int y, int x){
        visited[y][x] = 1;
        map[y][x] = 2;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m)
                continue;
            if(visited[ny][nx] == 0 && map[ny][nx] == 0)
                dfs(ny, nx);
        }
    }
    static int go(int y, int x){
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 2 && visited[i][j] == 0)
                    dfs(i, j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && map[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int x = Integer.parseInt(st.nextToken());
                if(x == 0)
                    empty.add(new Point(j, i));
                else if(x == 1)
                    wall.add(new Point(j, i));
                else if(x == 2)
                    virus.add(new Point(j, i));
            }
        }
        int ret = 0;
        for(int i = 0; i < empty.size(); i++){
            for(int j = i + 1; j < empty.size(); j++){
                for(int k = j + 1; k < empty.size(); k++){
                    map = new int[12][12];
                    visited = new int[12][12];
                    for(Point p : wall)
                        map[p.y][p.x] = 1;
                    for(Point p : virus)
                        map[p.y][p.x] = 2;
                    Point p1 = new Point(empty.get(i));
                    Point p2 = new Point(empty.get(j));
                    Point p3 = new Point(empty.get(k));
                    map[p1.y][p1.x] = 1;
                    map[p2.y][p2.x] = 1;
                    map[p3.y][p3.x] = 1;
                    ret = Math.max(ret, go(0, 0));
                }
            }
        }
        System.out.println(ret);
    }
}