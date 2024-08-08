import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe17144_4 {
    static int n, m, t, ret = 0;
    static boolean flag = false;
    static int[][] a = new int[54][54];
    static List<Point> li1 = new ArrayList<>();
    static List<Point> li2 = new ArrayList<>();
    static int[] dy1 = {0, -1, 0, 1};
    static int[] dx1 = {1, 0, -1, 0};
    static int[] dy2 = {0, 1, 0, -1};
    static int[] dx2 = {1, 0, -1, 0};
    static List<Point> getRoad(int y, int x, int[] dy, int[] dx){
        int idx = 0;
        List<Point> li = new ArrayList<>();
        while(true){
            int ny = y + dy[idx];
            int nx = x + dx[idx];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m){
                idx++;
                ny = y + dy[idx];
                nx = x + dx[idx];
            }
            if(a[ny][nx] == -1) break;
            li.add(new Point(nx, ny));
            y = ny;
            x = nx;
        }
        return li;
    }
    static void spread(){
        int[][] temp = new int[54][54];
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == -1) continue;
                q.add(new Point(j, i));
            }
        }
        while(!q.isEmpty()){
            Point p = q.poll();
            int num = a[p.y][p.x] / 5;
            for(int i = 0; i < 4; i++){
                int ny = p.y + dy1[i];
                int nx = p.x + dx1[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(a[ny][nx] == -1) continue;
                temp[ny][nx] += num;
                a[p.y][p.x] -= num;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] += temp[i][j];
            }
        }
    }
    static void clean(List<Point> li){
        Deque<Integer> dq = new ArrayDeque<>();
        for(Point p : li) dq.addLast(a[p.y][p.x]);
        dq.addFirst(0);
        for(Point p : li) a[p.y][p.x] = dq.pollFirst();
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] == -1 && !flag){
                    flag = true;
                    li1 = getRoad(i, j, dy1, dx1);
                }else if(a[i][j] == -1 && flag){
                    li2 = getRoad(i, j, dy2, dx2);
                }
            }
        }
        while(t-- > 0){
            spread();
            clean(li1);
            clean(li2);
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