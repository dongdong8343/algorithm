import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe5719_1 {
    static int n, m, s, e, u, v, p;
    static int[][] a = new int[504][504];
    static int[] dist = new int[504];
    static void di(){
        Arrays.fill(dist, 987654321);
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.x));
        dist[s] = 0;
        pq.add(new Point(0, s));
        while(!pq.isEmpty()){
            Point p = pq.poll();
            int here = p.y, d = p.x;
            if(d != dist[here]) continue;
            for(int i = 0; i < n; i++){
                if(a[here][i] == -1) continue;
                int nd = a[here][i] + dist[here];
                if(nd < dist[i]){
                    dist[i] = nd;
                    pq.add(new Point(dist[i], i));
                }
            }
        }
    }
    static void er(){
        Queue<Integer> q = new LinkedList<>();
        q.add(e);
        while(!q.isEmpty()){
            int t = q.poll();
            for(int i = 0; i < n; i++){
                if(dist[t] == dist[i] + a[i][t] && a[i][t] != -1){
                    q.add(i);
                    a[i][t] = -1;
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
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            for(int[] row : a){
                Arrays.fill(row, -1);
            }
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());
                a[u][v] = p;
            }
            di();
            er();
            di();
            if(dist[e] == 987654321) System.out.println(-1);
            else System.out.println(dist[e]);
        }
    }
}