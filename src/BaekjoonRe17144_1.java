import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe17144_1 {
    static int n, m, t, ret = 0;
    static List<Point> li1 = new ArrayList<>();
    static List<Point> li2 = new ArrayList<>();
    static int[][] a = new int[54][54];
    static int[] dy1 = {0, -1, 0, 1};
    static int[] dx1 = {1, 0, -1, 0};
    static int[] dy2 = {0, 1, 0, -1};
    static int[] dx2 = {1, 0, -1, 0};
    static void move(){
        int[][] temp = new int[54][54];
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != -1 && a[i][j] > 0) q.add(new Point(j, i));
            }
        }
        while(!q.isEmpty()){
            Point p = q.poll();
            int spread = a[p.y][p.x] / 5;
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy1[i];
                int nx = p.x + dx1[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == -1) continue;
                temp[ny][nx] += spread;
                a[p.y][p.x] -= spread;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] += temp[i][j];
            }
        }
    }
    static List<Point> area(int sy, int sx, int[] dy, int[] dx){
        List<Point> li = new ArrayList<>();
        int y = sy;
        int x = sx;
        int cnt = 0;
        while(true){
            int ny = y + dy[cnt];
            int nx = x + dx[cnt];
            if(ny == sy && nx == sx) break;
            if(ny < 0 || nx < 0 || ny >= n || nx >= m){
                cnt++;
                ny = y + dy[cnt];
                nx = x + dx[cnt];
            }
            if(ny == sy && nx == sx) break;
            li.add(new Point(nx, ny));
            y = ny;
            x = nx;
        }
        return li;
    }
    static void go(List<Point> li){
        for(int i = li.size() - 1; i > 0; i--) {
            a[li.get(i).y][li.get(i).x] = a[li.get(i - 1).y][li.get(i - 1).x];
        }
        a[li.get(0).y][li.get(0).x] = 0;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        boolean flag = true;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] == -1){
                    if(flag){
                        li1 = area(i, j, dy1, dx1);
                        flag = false;
                    }else li2 = area(i, j, dy2, dx2);
                }
            }
        }
        while(t-- > 0){
            move();
            go(li1);
            go(li2);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != -1) ret += a[i][j];
            }
        }
        System.out.println(ret);
    }
}