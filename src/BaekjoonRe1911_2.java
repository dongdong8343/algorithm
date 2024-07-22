import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe1911_2 {
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
            return o1.x - o2.x;
        });
        int here = 0;
        for(Point t : li){
            if(here > t.x) t.x = here;
            if(t.x >= t.y) continue;
            ret += (t.y - t.x) / l;
            if((t.y - t.x) % l != 0) {
                ret++;
                here = (t.y + (l - (t.y - t.x) % l));
            }
        }
        System.out.println(ret);
    }
}