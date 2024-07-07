import java.util.*;
import java.io.*;
import java.awt.Point;

public class Baekjoon17144 {
    static int r, c, t;
    static int[][] map = new int[54][54];
    static List<Point> li1 = new ArrayList<>();
    static List<Point> li2 = new ArrayList<>();
    static int[] dy1 = {0, -1, 0, 1};
    static int[] dx1 = {1, 0, -1, 0};
    static int[] dy2 = {0, 1, 0, -1};
    static int[] dx2 = {1, 0, -1, 0};
    static void spread(){
        Queue<Point> q = new LinkedList<>();
        int[][] temp = new int[54][54];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] != -1 && map[i][j] > 0) q.add(new Point(j, i));
            }
        }
        while(!q.isEmpty()){
            Point p = q.poll();
            int sp = map[p.y][p.x] / 5;
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy1[i];
                int nx = p.x + dx1[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c || map[ny][nx] == -1) continue;
                temp[ny][nx] += sp;
                map[p.y][p.x] -= sp;
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                map[i][j] += temp[i][j];
            }
        }
    }
    static List<Point> road(int sy, int sx, int[] dy, int[] dx){
        List<Point> li = new ArrayList<>();
        int cnt = 0;
        int y = sy;
        int x = sx;
        while(true){
            int ny = y + dy[cnt];
            int nx = x + dx[cnt];
            if(ny == sy && nx == sx) break;
            if(ny < 0 || nx < 0 || ny >= r || nx >= c){
                cnt++;
                ny = y + dy[cnt];
                nx = x + dx[cnt];
            }
            if(ny == sy && nx == sx) break;
            y = ny; x = nx;
            li.add(new Point(nx, ny));
        }
        return li;
    }
    static void go(List<Point> li){
        for(int i = li.size() - 1; i > 0; i--){
            map[li.get(i).y][li.get(i).x] = map[li.get(i - 1).y][li.get(i - 1).x];
        }
        map[li.get(0).y][li.get(0).x] = 0;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        boolean flag = true;
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    if(flag) {
                        li1 = road(i, j, dy1, dx1);
                        flag = false;
                    }
                    else li2 = road(i, j, dy2, dx2);
                }
            }
        }
        for(int i = 0; i < t; i++){
            spread();
            go(li1);
            go(li2);
        }
        int ret = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] != -1)
                    ret += map[i][j];
            }
        }
        System.out.println(ret);
    }
}
