import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe1911_1 {
    static int n, l, ret = 0;
    static List<Point> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            li.add(new Point(s, e));
        }
        Collections.sort(li, (o1, o2) -> {
            return o1.x - o2.x;
        });
        int here = 0;
        for(Point p : li){
            if(here >= p.y) continue;
            if(here < p.x) here = p.x;
            ret += (p.y - here) / l;
            if((p.y - here) % l != 0) {
                ret++;
                here = p.y + (l - (p.y - here) % l);
            }else here = p.y;
        }
        System.out.println(ret);
    }
}