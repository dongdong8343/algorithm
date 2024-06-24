import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReReReRe3197 {
    static int r, c, ok = 0;
    static Queue<Point> water = new LinkedList<>();
    static Queue<Point> swan = new LinkedList<>();
    static Queue<Point> swan2 = new LinkedList<>();
    static char[][] map;
    static int[][] sVisited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int move(){
        while(!swan.isEmpty()){
            Point p = swan.poll();
            int x = p.x;
            int y = p.y;
            for(int j = 0; j < 4; j++){
                int ny = y + dy[j];
                int nx = x + dx[j];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c || sVisited[ny][nx] == 1) continue;

                if(map[ny][nx] == 'L') return 1;
                sVisited[ny][nx] = 1;
                if(map[ny][nx] == 'X') {
                    swan2.add(new Point(nx, ny));
                    continue;
                }
                swan.add(new Point(nx, ny));
            }
        }
        return 0;
    }
    static void melt(){
        int qsize = water.size();
        for(int i = 0; i < qsize; i++){
            Point p = water.poll();
            int y = p.y;
            int x = p.x;
            for(int j = 0; j < 4; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                if(map[ny][nx] == 'X') {
                    map[ny][nx] = '.';
                    water.add(new Point(nx, ny));
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        sVisited = new int[r][c];
        Point p;
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == '.' || map[i][j] == 'L')
                    water.add(new Point(j, i));
                if(ok == 0 && map[i][j] == 'L') {
                    ok = 1;
                    sVisited[i][j] = 1;
                    swan.add(new Point(j, i));
                }
            }
        }
        int cnt = 0;
        while(true){
            melt();
            if(move() == 1) break;
            swan = swan2;
            swan2 = new LinkedList<>();
            cnt++;
        }
        System.out.println(cnt + 1);
    }
}