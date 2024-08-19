import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe1911_4 {
    static int n, l, s = 0, ret = 0;
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
            li.add((new Point(x, y)));
        }
        Collections.sort(li, (o1, o2) -> {
            return o1.x - o2.x;
        });
        for(int i = 0; i < n; i++){
            if(s >= li.get(i).y) continue;
            if(s < li.get(i).x) s = li.get(i).x;
            int temp = (li.get(i).y - s) / l;
            if((li.get(i).y - s) % l != 0) temp++;
            ret += temp;
            s = l * temp + s;
        }
        System.out.println(ret);
    }
}