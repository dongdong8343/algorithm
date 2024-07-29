import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe1911_3 {
    static int n, l, ret = 0;
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
            if(o1.x == o2.x) return o1.y - o2.y;
            return o1.x - o2.x;
        });
        int here = li.get(0).x;
        for(Point p : li){
            if(here < p.x) here = p.x;
            if(here >= p.y) continue;
            int cnt = 0;
            cnt = (p.y - here) / l;
            if((p.y - here) % l != 0) cnt++;
            ret += cnt;
            here += l * cnt;
        }
        System.out.println(ret);
    }
}