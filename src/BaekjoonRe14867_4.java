import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe14867_4 {
    static int a, b, c, d;
    static HashMap<Point, Integer> hs = new HashMap<>();
    static Queue<Point> q = new LinkedList<>();
    static int go(int x, int y){
        q.add(new Point(0, 0));
        hs.put(new Point(0, 0), 1);
        while(!q.isEmpty()){
            Point p = q.poll();
            enqueue(p.x, p.y, a, p.y);
            enqueue(p.x, p.y, p.x, b);
            enqueue(p.x, p.y, 0, p.y);
            enqueue(p.x, p.y, p.x, 0);
            enqueue(p.x, p.y, Math.max(0, p.x - (b - p.y)), Math.min(b, p.x + p.y));
            enqueue(p.x, p.y, Math.min(a, p.x + p.y), Math.max(0, p.y - (a - p.x)));
        }
        return hs.getOrDefault(new Point(c, d), 0) - 1;
    }
    static void enqueue(int x, int y, int nx, int ny){
        if(hs.containsKey(new Point(nx, ny))) return;
        q.add(new Point(nx, ny));
        hs.put(new Point(nx, ny), hs.get(new Point(x, y)) + 1);
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