import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon14867 {
    static int a, b, c, d;
    static HashMap<Point, Integer> hs = new HashMap<>();
    static Queue<Point> q = new LinkedList<>();
    static void enqueue(int x, int y, int d){
        Point p = new Point(x, y);
        if(hs.containsKey(p)) return;
        hs.put(p, d + 1);
        q.add(p);
    }
    static int go(int x, int y){
        hs.put(new Point(x, y), 1);
        q.add(new Point(x, y));
        while(!q.isEmpty()){
            Point p = q.poll();
            x = p.x; y = p.y;
            enqueue(a, y, hs.get(p));
            enqueue(x, b, hs.get(p));
            enqueue(0, y, hs.get(p));
            enqueue(x, 0, hs.get(p));
            enqueue(Math.min(x + y, a), Math.max(0, x + y - a), hs.get(p));
            enqueue(Math.max(0, x + y - b), Math.min(x + y, b), hs.get(p));
        }
        return hs.getOrDefault(new Point(c, d), 0) - 1;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        System.out.println(go(0, 0));
    }
}