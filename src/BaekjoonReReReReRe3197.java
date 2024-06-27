import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReReReReRe3197 {
    static int r, c;
    static char[][] map;
    static int[][] sVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static Queue<Point> swan1 = new LinkedList<>();
    static Queue<Point> swan2 = new LinkedList<>();
    static Queue<Point> water = new LinkedList<>();
    static Point p;
    static void melt(){
        int size = water.size();
        for(int i = 0; i < size; i++){
            Point t = water.poll();
            for(int j = 0; j < 4; j++){
                int ny = t.y + dy[j];
                int nx = t.x + dx[j];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                if(map[ny][nx] == 'X'){
                    map[ny][nx] = '.';
                    water.add(new Point(nx, ny));
                }
            }
        }
    }
    static boolean move(){
        while(!swan1.isEmpty()){
            Point t = swan1.poll();
            for(int i = 0; i < 4; i++){
                int ny = t.y + dy[i];
                int nx = t.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c || sVisited[ny][nx] == 1) continue;
                if(map[ny][nx] == 'L') return true;
                sVisited[ny][nx] = 1;
                if(map[ny][nx] == 'X') {
                    swan2.add(new Point(nx, ny));
                    continue;
                }
                swan1.add(new Point(nx, ny));
            }
        }
        return false;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r + 4][c + 4];
        sVisited = new int[r + 4][c + 4];
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == '.' || map[i][j] == 'L')
                    water.add(new Point(j, i));
                if(map[i][j] == 'L')
                    p = new Point(j, i);
            }
        }
        swan1.add(p);
        sVisited[p.y][p.x] = 1;
        int turn = 0;
        while(true){
            turn++;
            melt();
            if(move()){
                System.out.println(turn);
                return;
            }
            swan1 = swan2;
            swan2 = new LinkedList<>();
        }
    }
}