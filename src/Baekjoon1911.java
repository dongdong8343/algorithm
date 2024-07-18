import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon1911 {
    static int n, l;
    static long ret = 0;
    static List<Point> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            li.add(new Point(x, y));
        }
        Collections.sort(li, (o1, o2) -> {
            return o1.x - o2.x;
        });
        int here = 0;
        for(Point p : li){
            if(here > p.x) p.x = here;
            if(p.x >= p.y) continue;
            int t = p.y - p.x;
            ret += t / l;
            here = p.y;
            if(t % l != 0) {
                ret++;
                here = p.y + (l - t % l);
            }
        }
        System.out.println(ret);
    }
}