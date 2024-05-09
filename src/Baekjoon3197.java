import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon3197 {
    static int n, m, turn = 1;
    static char[][] map;
    static int[][] bVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static Point p;
    static Queue<Point> water = new LinkedList<>();
    static Queue<Point> swan = new LinkedList<>();
    static Queue<Point> tswan = new LinkedList<>();
    static int moveSwan(){
        while(!swan.isEmpty()){
            Point temp = swan.poll();
            int x = temp.x;
            int y = temp.y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int idx = 1000 * nx + ny;
                if(nx < 0 || ny < 0 || nx >= m || ny >= n || bVisited[ny][nx] == 1) continue;
                if(map[ny][nx] == 'L') return 1;
                bVisited[ny][nx] = 1;
                if(map[ny][nx] == 'X') {
                    tswan.add(new Point(nx, ny));
                    continue;
                }
                swan.add(new Point(nx, ny));
            }
        }
        return 0;
    }

    static void watermelting(){
        int size = water.size();
        for(int j = 0; j < size; j++){
            Point temp = water.poll();
            int x = temp.x;
            int y = temp.y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                else if(map[ny][nx] == 'X'){
                    map[ny][nx] = '.';
                    water.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        bVisited = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'L') p = new Point(j, i);
                if(map[i][j] == '.' || map[i][j] == 'L') water.add(new Point(j, i));
            }
        }

        swan.add(p);
        bVisited[p.y][p.x] = 1;

        while(true){
            watermelting();
            if(moveSwan() == 1) break;
            swan = tswan;
            tswan = new LinkedList<>();
            turn++;
        }

        System.out.println(turn);
    }
}