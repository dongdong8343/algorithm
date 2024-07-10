import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe3190_1 {
    static int n, k, l, time = 0, idx = 0;
    static int[] v = new int[10004];
    static int[][] a = new int[104][104];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Queue<Character> q = new LinkedList<>();
    static Deque<Point> dq = new ArrayDeque<>();
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
            int t = Integer.parseInt(st.nextToken());
            v[t] = 1;
            q.add(st.nextToken().charAt(0));
        }
        dq.add(new Point(0, 0));
        a[0][0] = 2;
        while(true){
            time++;
            int ny = dq.peekFirst().y + dy[idx];
            int nx = dq.peekFirst().x + dx[idx];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || a[ny][nx] == 2){
                System.out.println(time);
                return;
            }
            if(a[ny][nx] == 1) a[ny][nx] = 0;
            else{
                Point temp = dq.pollLast();
                a[temp.y][temp.x] = 0;
            }
            dq.addFirst(new Point(nx, ny));
            a[ny][nx] = 2;
            if(v[time] != 0){
                char c = q.poll();
                if(c == 'L') {
                    if(idx == 0) idx = 3;
                    else idx--;
                }
                else{
                    if(idx == 3) idx = 0;
                    else idx++;
                }
            }
        }
    }
}