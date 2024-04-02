import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;

public class Baekjoon14502 {
    static List<Point> virus = new ArrayList<>();
    static List<Point> wall = new ArrayList<>();
    static List<Point> empty = new ArrayList<>();
    static List<Point> newWall = new ArrayList<>();
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n, m;
    static void dfs(int y, int x){
        visited[y][x] = 1;
        map[y][x] = 2;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;
            if(visited[ny][nx] == 0 && map[ny][nx] == 0)
                dfs(ny, nx);
        }
    }
    static int solve(){
        map = new int[12][12];
        for(Point p : virus)
            map[p.y][p.x] = 2;
        for(Point p : wall)
            map[p.y][p.x] = 1;
        for(Point p : newWall)
            map[p.y][p.x] = 1;
        visited = new int[12][12];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && map[i][j] == 2)
                    dfs(i, j);
            }
        }

        int cnt = 0;
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
                int space = Integer.parseInt(st.nextToken());
                Point p = new Point();
                p.y = i;
                p.x = j;
                if(space == 1)
                    wall.add(p);
                else if(space == 2)
                    virus.add(p);
                else
                    empty.add(p);
            }
        }
        int ret = 0;
        for(int i = 0; i < empty.size(); i++){
            for(int j = i + 1; j < empty.size(); j++){
                for(int k = j + 1; k < empty.size(); k++){
                    newWall.add(empty.get(i));
                    newWall.add(empty.get(j));
                    newWall.add(empty.get(k));
                    ret = Math.max(ret, solve());
                    newWall.clear();
                }
            }
        }
        System.out.println(ret);
    }
}
