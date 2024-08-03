import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe2109_4 {
    static int n, p, d, ret = 0;
    static List<Point> li = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            li.add(new Point(d, p));
        }
        Collections.sort(li, (o1, o2) -> {
            return o1.x - o2.x;
        });
        for(int i = 0; i < n; i++){
            pq.add(li.get(i).y);
            if(li.get(i).x < pq.size()) pq.poll();
        }
        while(!pq.isEmpty()) ret += pq.poll();
        System.out.println(ret);
    }
}