import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon17144_3 {
    static int n, m, t, ret = 0;
    static int[][] a = new int[1004][1004];
    static int[] dy1 = {0, -1, 0, 1};
    static int[] dx1 = {1, 0, -1, 0};
    static int[] dy2 = {0, 1, 0, -1};
    static int[] dx2 = {1, 0, -1, 0};
    static List<Point> li1 = new ArrayList<>();
    static List<Point> li2 = new ArrayList<>();
    static List<Point> go(int sy, int sx, int[] dy, int[] dx){
        List<Point> li = new ArrayList<>();
        int idx = 0;
        int y = sy;
        int x = sx;
        while(true){
            int ny = y + dy[idx];
            int nx = x + dx[idx];
            if(ny >= n || nx >= m || ny < 0 || nx < 0){
                idx++;
                ny = y + dy[idx];
                nx = x + dx[idx];
            }
            if(ny == sy && nx == sx) break;
            li.add(new Point(nx, ny));
            y = ny;
            x = nx;
        }
        return li;
    }
    static void spread(){
        int[][] temp = new int[1004][1004];
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != -1 && a[i][j] > 0) q.add(new Point(j, i));
            }
        }
        while(!q.isEmpty()){
            Point p = q.poll();
            int s = a[p.y][p.x] / 5;
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy1[i];
                int nx = p.x + dx1[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] == -1) continue;
                temp[ny][nx] += s;
                a[p.y][p.x] -= s;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] += temp[i][j];
            }
        }
    }
    static void clear(List<Point> li){
        for(int i = li.size() - 1; i >= 1; i--){
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
        boolean flag = false;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] == -1 && !flag){
                    li1 = go(i, j, dy1, dx1);
                    flag = true;
                }else if(a[i][j] == -1 && flag){
                    li2 = go(i, j, dy2, dx2);
                }
            }
        }
        while(t-- > 0){
            spread();
            clear(li1);
            clear(li2);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == -1) continue;
                ret += a[i][j];
            }
        }
        System.out.println(ret);
    }
}