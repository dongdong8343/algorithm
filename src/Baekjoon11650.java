import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon11650 {
    static int n;
    static List<Point> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            li.add(new Point(x, y));
        }
        Collections.sort(li, (o1, o2) -> {
            if(o1.x == o2.x) return o1.y - o2.y;
            return o1.x - o2.x;
        });
        for(Point p : li) System.out.println(p.x + " " + p.y);
    }
}