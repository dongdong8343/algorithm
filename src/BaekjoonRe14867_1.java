import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe14867_1 {
    static int a, b, c, d;
    static Queue<Point> q = new LinkedList<>();
    static HashMap<Point, Integer> hs = new HashMap<>();
    static int bfs(){
        q.add(new Point(0, 0));
        hs.put(new Point(0, 0), 1);
        while(!q.isEmpty()){
            Point p = q.poll();
            int num = hs.get(p);
            go(a, p.y, num);
            go(p.x, b, num);
            go(0, p.y, num);
            go(p.x, 0, num);
            go(Math.max(0, p.x - (b - p.y)), Math.min(b, p.y + p.x), num);
            go(Math.min(a, p.x + p.y), Math.max(0, p.y - (a - p.x)), num);
        }
        return hs.getOrDefault(new Point(c, d), 0) - 1;
    }
    static void go(int x, int y, int num){
        Point p = new Point(x, y);
        if(hs.containsKey(p)) {
            return;
        }
        q.add(p);
        hs.put(p, num + 1);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        System.out.println(bfs());
    }
}