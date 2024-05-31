import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonReRe3197 {
    static int n, m, turn, ok = 0;
    static char[][] map = new char[1504][1504];
    static int[][] wv = new int[1504][1504];
    static int[][] sv = new int[1504][1504];

    static Queue<Point> water = new LinkedList<>();
    static Queue<Point> swan = new LinkedList<>();
    static Queue<Point> swan2 = new LinkedList<>();

    static Point tSwan;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static void move(){
        while(!swan.isEmpty()){
            Point temp = swan.poll();
            for(int j = 0; j < 4; j++){
                int ny = temp.y + dy[j];
                int nx = temp.x + dx[j];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || sv[ny][nx] != 0) continue;
                if(map[ny][nx] == 'L'){
                    ok = 1;
                    break;
                }
                if(map[ny][nx] == '.') {
                    swan.add(new Point(nx, ny));
                }
                else swan2.add(new Point(nx, ny));
                sv[ny][nx] = 1;
            }
            if(ok == 1) break;
        }
    }
    static void melt(){
        int qsize = water.size();
        for(int i = 0; i < qsize; i++){
            Point temp = water.poll();
            for(int j = 0; j < 4; j++){
                int ny = temp.y + dy[j];
                int nx = temp.x + dx[j];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || wv[ny][nx] != 0) continue;
                if(map[ny][nx] == 'X'){
                    map[ny][nx] = '.';
                    wv[ny][nx] = 1;
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
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == '.' || map[i][j] == 'L') {
                    wv[i][j] = 1;
                    water.add(new Point(j, i));
                }
                if(map[i][j] == 'L') tSwan = new Point(j, i);
            }
        }
        swan.add(tSwan);
        sv[tSwan.y][tSwan.x] = 1;
        while(true){
            move();
            if(ok == 1) {
                System.out.println(turn);
                return;
            }
            melt();
            swan = swan2;
            swan2 = new LinkedList<>();
            turn++;
        }
    }
}