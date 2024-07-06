import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe2109_2 {
    static int n, ret = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static List<Point> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            li.add(new Point(d, p));
        }
        Collections.sort(li, (o1, o2) -> o1.x - o2.x);
        for(int i = 0; i < n; i++){
            pq.add(li.get(i).y);
            if(li.get(i).x < pq.size()) pq.poll();
        }
        while(!pq.isEmpty()) ret += pq.poll();
        System.out.println(ret);
    }
}