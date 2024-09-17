import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon18352 {
    static int n, m, k, x, s, e;
    static List<Point>[] a = new List[300004];
    static List<Integer> li = new ArrayList<>();
    static int[] dist = new int[300004];
    static void di(){
        Arrays.fill(dist, 987654321);
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.y));
        dist[x] = 0;
        pq.add(new Point(x, 0));
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(dist[p.x] != p.y) continue;
            for(Point temp : a[p.x]){
                if(dist[temp.x] > temp.y + dist[p.x]){
                    dist[temp.x] = temp.y + dist[p.x];
                    pq.add(new Point(temp.x, dist[temp.x]));
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()) - 1;
        for(int i = 0; i < 300004; i++) a[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;
            a[s].add(new Point(e, 1));
        }
        di();
        for(int i = 0; i < n; i++){
            if(k == dist[i]) li.add(i + 1);
        }
        if(li.size() == 0) System.out.println(-1);
        else{
            Collections.sort(li);
            for(int x : li) sb.append(x).append('\n');
        }
        System.out.println(sb);
    }
}