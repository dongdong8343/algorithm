import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe2109_3 {
    static int n, sum = 0;
    static List<Point> li = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            li.add(new Point(p, d));
        }
        Collections.sort(li, (o1, o2) -> {
            return o1.y - o2.y;
        });
        for(int i = 0; i < n; i++){
            pq.add(li.get(i).x);
            if(pq.size() > li.get(i).y) pq.poll();
        }
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}