import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe3190_3 {
    static int n, k, l, time = 0, idx = 0;
    static int[][] a = new int[104][104];
    static Queue<Character> q = new LinkedList<>();
    static int[] v = new int[10004];
    static Deque<Point> dq = new ArrayDeque<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            a[y - 1][x - 1] = 1;
        }
        l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            q.add(c);
            v[a] = 1;
        }
        int y = 0; int x = 0;
        a[y][x] = 2;
        dq.add(new Point(x, y));
        while(true){
            time++;
            int ny = y + dy[idx];
            int nx = x + dx[idx];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == 2) {
                System.out.println(time);
                return;
            }
            if(a[ny][nx] == 1){
                a[ny][nx] = 0;
            }else{
                Point p = dq.pollLast();
                a[p.y][p.x] = 0;
            }
            a[ny][nx] = 2;
            dq.addFirst(new Point(nx, ny));
            if(v[time] != 0){
                char c = q.poll();
                if(c == 'D'){
                    if(idx == 3) idx = 0;
                    else idx++;
                }else if(c == 'L'){
                    if(idx == 0) idx = 3;
                    else idx--;
                }
            }
            y = ny;
            x = nx;
        }
    }
}