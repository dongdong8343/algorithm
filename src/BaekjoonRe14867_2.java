import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe14867_2 {
    static int a, b, c, d;
    static HashMap<Point, Integer> hs = new HashMap<>();
    static Queue<Point> q = new LinkedList<>();
    static int go(){
        q.add(new Point(0, 0));
        hs.put(new Point(0, 0), 1);
        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x; int y = p.y; int d = hs.get(p);
            en(x, b, d);
            en(a, y, d);
            en(x, 0, d);
            en(0, y, d);
            en(Math.max(0, x - (b - y)), Math.min(b, x + y), d);
            en(Math.min(a, x + y), Math.max(0, y - (a - x)), d);
        }
        return hs.getOrDefault(new Point(c, d), 0) - 1;
    }
    static void en(int x, int y, int d){
        Point p = new Point(x, y);
        if(hs.containsKey(p)) return;
        hs.put(p, d + 1);
        q.add(p);
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