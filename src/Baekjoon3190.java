import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon3190 {
    static int n, k, l, cnt = 0, idx = 0;
    static int[][] map = new int[104][104];
    static int[] v = new int[10004];
    static Deque<Point> de = new ArrayDeque<>();
    static boolean over = false;
    static Queue<Character> q = new LinkedList<>();
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
            map[y - 1][x - 1] = 1;
        }
        l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            v[a] = 1;
            q.add(c);
        }
        de.addFirst(new Point(0, 0));
        map[0][0] = 2;
        while(!de.isEmpty()){
            cnt++;
            Point p = de.peekFirst();
            int ny = p.y + dy[idx];
            int nx = p.x + dx[idx];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] == 2) break;
            if(map[ny][nx] == 1){
                map[ny][nx] = 0;
            }else{
                Point temp = de.pollLast();
                map[temp.y][temp.x] = 0;
            }
            de.addFirst(new Point(nx, ny));
            map[ny][nx] = 2;
            if(v[cnt] != 0){
                if(q.poll() == 'L') {
                    if(idx == 0) idx = 3;
                    else idx--;
                }else{
                    if(idx == 3) idx = 0;
                    else idx++;
                }
            }
        }
        System.out.println(cnt);
    }
}