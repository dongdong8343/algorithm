import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon5719 {
    static int n, m, s, d;
    static int[] dist = new int[504];
    static final int INF = 987654321;
    static int[][] a = new int[504][504];
    public static void di(){
        Arrays.fill(dist, INF);
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.x));
        pq.add(new Point(0, s));
        dist[s] = 0;

        while(!pq.isEmpty()){
            Point cur = pq.poll();
            int here = cur.y;
            int hd = cur.x;
            if(dist[here] != hd) continue;
            for(int i = 0; i < n; i++){
                if(a[here][i] == -1) continue;
                int _dist = a[here][i];
                if(dist[i] > dist[here] + _dist){
                    dist[i] = dist[here] + _dist;
                    pq.add(new Point(dist[i], i));
                }
            }
        }
    }
    public static void er(){
        Queue<Integer> q = new LinkedList<>();
        q.add(d);
        while(!q.isEmpty()){
            int c = q.poll();
            for(int i = 0; i < n; i++){
                if(dist[c] == dist[i] + a[i][c] && a[i][c] != -1){
                    a[i][c] = -1;
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            a = new int[n+4][n+4];
            dist = new int[n + 4];
            for(int[] row : a){
                Arrays.fill(row, -1);
            }
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                a[u][v] = p;
            }
            di();
            er();
            di();

            System.out.println(dist[d] == 987654321 ? -1 : dist[d]);
        }
    }
}