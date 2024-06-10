import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReReRe3197 {
    static int r, c, turn = 0;
    static char[][] map = new char[1504][1504];
    static int[][] sv = new int[1504][1504];
    static int[][] wv = new int[1504][1504];
    static Queue<Point> swan1 = new LinkedList<>();
    static Queue<Point> swan2 = new LinkedList<>();
    static Queue<Point> water = new LinkedList<>();
    static Point p;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static void go(){
        int size = water.size();
        for(int i = 0; i < size; i++){
            Point temp = water.poll();
            for(int j = 0; j < 4; j++){
                int nx = temp.x + dx[j];
                int ny = temp.y + dy[j];
                if(nx < 0 || ny < 0 || ny >= r || nx >= c || wv[ny][nx] == 1) continue;
                if(map[ny][nx] == 'X'){
                    map[ny][nx] = '.';
                    water.add(new Point(nx, ny));
                }
            }
        }
    }
    static boolean move(){
        while(!swan1.isEmpty()){
            Point temp = swan1.poll();
            for(int i = 0; i < 4; i++){
                int ny = temp.y + dy[i];
                int nx = temp.x + dx[i];
                if(nx < 0 || ny < 0 || ny >= r || nx >= c || sv[ny][nx] == 1) continue;
                if(map[ny][nx] == 'L') return true;
                if(map[ny][nx] == '.') swan1.add(new Point(nx, ny));
                else if(map[ny][nx] == 'X') swan2.add(new Point(nx, ny));
                sv[ny][nx] = 1;
            }
        }
        return false;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'L') p = new Point(j, i);
                if(map[i][j] == '.' || map[i][j] == 'L'){
                    wv[i][j] = 1;
                    water.add(new Point(j, i));
                }
            }
        }

        swan1.add(p);
        sv[p.y][p.x] = 1;

        while(true){
            go();
            turn++;
            if(move()){
                System.out.println(turn);
                return;
            }
            swan1 = swan2;
            swan2 = new LinkedList<>();
        }
    }
}