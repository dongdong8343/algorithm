import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReReRe14502 {
    static int n, m, max = -987654321;
    static int[][] map = new int[12][12];
    static int[][] visited = new int[12][12];
    static int[][] virus = new int[12][12];
    static List<Point> li = new ArrayList<>();
    static List<Point> lVirus = new ArrayList<>();
    static List<Point> wall = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static void dfs(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] == 1) continue;
            if(map[ny][nx] == 0){
                virus[ny][nx] = 2;
                dfs(ny, nx);
            }
        }
    }
    static void empty(){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(virus[i][j] != 2 && map[i][j] == 0) cnt++;
            }
        }
        max = Math.max(max, cnt);
    }
    static void combi(){
        for(int i = 0; i < li.size(); i++){
            for(int j = 0; j < i; j++){
                for(int k = 0; k < j; k++){
                    wall.add(li.get(i));
                    wall.add(li.get(j));
                    wall.add(li.get(k));
                    for(Point p : wall){
                        map[p.y][p.x] = 1;
                    }
                    for(Point p : lVirus){
                        dfs(p.y, p.x);
                    }
                    empty();
                    for(Point p : wall){
                        map[p.y][p.x] = 0;
                    }
                    virus = new int[12][12];
                    for(Point p : lVirus) virus[p.y][p.x] = 2;
                    wall.clear();
                    visited = new int[12][12];
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
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 0){
                    map[i][j] = 0;
                    li.add(new Point(j, i));
                }else if(temp == 1){
                    map[i][j] = 1;
                }
                else{
                    lVirus.add(new Point(j, i));
                    virus[i][j] = 2;
                }
            }
        }
        combi();
        System.out.println(max);
    }
}
