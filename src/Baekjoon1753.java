import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon1753 {
    static class Node{
        int e, d;
        Node(int e, int d){
            this.e = e;
            this.d = d;
        }
    }
    static int v, e, s, n1, n2, d;
    static final int INF = 987654321;
    static List<Node>[] a = new List[20004];
    static int[] dist = new int[20004];
    static void di(){
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.y));
        Arrays.fill(dist, INF);
        dist[s] = 0;
        pq.add(new Point(s, 0));
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(dist[p.x] != p.y) continue;
            for(Node n : a[p.x]){
                if(dist[n.e] > dist[p.x] + n.d){
                    dist[n.e] = dist[p.x] + n.d;
                    pq.add(new Point(n.e, dist[p.x] + n.d));
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(br.readLine()) - 1;
        for(int i = 0; i < 20004; i++) a[i] = new ArrayList<>();
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken()) - 1;
            n2 = Integer.parseInt(st.nextToken()) - 1;
            d = Integer.parseInt(st.nextToken());
            a[n1].add(new Node(n2, d));
        }
        di();
        for(int i = 0; i < v; i++){
            if(dist[i] == INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }
}