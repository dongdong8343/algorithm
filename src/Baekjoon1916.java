import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon1916 {
    static int n, m, s, e, d;
    static final int INF = 987654321;
    static int[] dist = new int[1004];
    static List<Point>[] a = new List[1004];
    static void di(){
        Arrays.fill(dist, INF);
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.y));
        pq.add(new Point(s, 0));
        dist[s] = 0;
        while(!pq.isEmpty()){
            Point temp = pq.poll();
            if(dist[temp.x] != temp.y) continue;
            for(Point p : a[temp.x]){
                if(dist[p.x] > dist[temp.x] + p.y){
                    dist[p.x] = dist[temp.x] + p.y;
                    pq.add(new Point(p.x, dist[p.x]));
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < 1004; i++) a[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;
            d = Integer.parseInt(st.nextToken());
            a[s].add(new Point(e, d));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken()) - 1;
        e = Integer.parseInt(st.nextToken()) - 1;
        di();
        System.out.println(dist[e]);
    }
}