import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe3190_4 {
    static int n, k, l, idx = 0, time = 0, y = 1, x = 1;
    static int[][] a = new int[104][104];
    static int[] arr = new int[10004];
    static Queue<Character> q = new LinkedList<>();
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
            a[y][x] = 1;
        }
        l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            arr[x] = 1;
            q.add(c);
        }
        a[1][1] = -1;
        dq.add(new Point(1, 1));
        while(true){
            time++;
            int ny = y + dy[idx];
            int nx = x + dx[idx];
            if(a[ny][nx] == -1 || ny < 1 || nx < 1 || ny > n || nx > n) {
                System.out.println(time);
                break;
            }
            if(a[ny][nx] == 1) a[ny][nx] = 0;
            else {
                Point p = dq.pollLast();
                a[p.y][p.x] = 0;
            }
            dq.addFirst(new Point(nx, ny));
            a[ny][nx] = -1;
            if(arr[time] != 0){
                char c = q.poll();
                if(c == 'L'){
                    idx--;
                    if(idx < 0) idx = 3;
                }else{
                    idx++;
                    if(idx > 3) idx = 0;
                }
            }
            y = ny;
            x = nx;
        }
    }
}