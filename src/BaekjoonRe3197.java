import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe3197 {
    static int n, m, meet = 0, turn = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static Point p;
    static Queue<Point> water = new LinkedList<>();
    static Queue<Point> swan = new LinkedList<>();
    static Queue<Point> tswan = new LinkedList<>();
    static int[][] visited;
    static char[][] map;
    static void ice(){
        int qsize = water.size();
        for(int i = 0; i < qsize; i++){
            Point temp = water.poll();
            int x = temp.x;
            int y = temp.y;
            for(int j = 0; j < 4; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(map[ny][nx] == 'X'){
                    map[ny][nx] = '.';
                    water.add(new Point(nx, ny));
                }
            }
        }
    }
    static void move(){
        while(!swan.isEmpty()){
            Point temp = swan.poll();
            int x = temp.x;
            int y = temp.y;
            for(int j = 0; j < 4; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx] == 1) continue;
                if(map[ny][nx] == 'L'){
                    meet = 1;
                    return;
                }
                visited[ny][nx] = 1;
                if (map[ny][nx] == '.') {
                    swan.add(new Point(nx, ny));
                    continue;
                }
                tswan.add(new Point(nx, ny));
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'L')
                    p = new Point(j, i);
                if(map[i][j] == 'L' || map[i][j] == '.'){
                    water.add(new Point(j, i));
                }
            }
        }
        swan.add(p);
        visited[p.y][p.x] = 1;
        while(true){
            turn++;
            ice();
            move();
            if(meet == 1) break;
            swan = tswan;
            tswan = new LinkedList<>();
        }
        System.out.println(turn);
    }
}