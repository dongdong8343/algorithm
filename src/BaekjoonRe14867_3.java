import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe14867_3 {
    static int a, b, c, d;
    static Queue<Point> q = new LinkedList<>();
    static HashMap<Point, Integer> hs = new HashMap<>();
    static int go(){
        q.add(new Point(0, 0));
        hs.put(new Point(0, 0), 1);
        while(!q.isEmpty()){
            Point p = q.poll();
            enqueue(a, p.y, p);
            enqueue(p.x, b, p);
            enqueue(0, p.y, p);
            enqueue(p.x, 0, p);
            enqueue(Math.max(0, p.x - (b - p.y)), Math.min(b, p.y + p.x), p);
            enqueue(Math.min(a, p.y + p.x), Math.max(0, p.y - (a - p.x)), p);
        }
        return hs.getOrDefault(new Point(c, d), 0) - 1;
    }
    static void enqueue(int x, int y, Point p){
        Point temp = new Point(x, y);
        if(hs.containsKey(temp)) return;
        hs.put(temp, hs.get(p) + 1);
        q.add(temp);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        System.out.println(go());
    }
}