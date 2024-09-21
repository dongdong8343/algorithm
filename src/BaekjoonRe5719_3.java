import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe5719_3 {
    static int n, m, s, e, u, v, p;
    static final int INF = 987654321;
    static int[][] a = new int[504][504];
    static int[] dist = new int[504];
    static void di(){
        Arrays.fill(dist, INF);
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.y));
        pq.add(new Point(s, 0));
        dist[s] = 0;
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(dist[p.x] != p.y) continue;
            for(int i = 0; i < n; i++){
                if(a[p.x][i] == -1) continue;
                if(dist[i] > dist[p.x] + a[p.x][i]){
                    dist[i] = dist[p.x] + a[p.x][i];
                    pq.add(new Point(i, dist[i]));
                }
            }
        }
    }
    static void erase(){
        Queue<Integer> q = new LinkedList<>();
        q.add(e);
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i = 0; i < n; i++){
                if(a[i][x] != -1 && dist[x] == dist[i] + a[i][x]){
                    a[i][x] = -1;
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            for(int[] row : a) {
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
            erase();
            di();
            if(dist[e] == 987654321) sb.append(-1).append('\n');
            else sb.append(dist[e]).append('\n');
        }
        System.out.println(sb);
    }
}