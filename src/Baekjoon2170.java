import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon2170 {
    static int n, sum = 0, here = -1987654321;
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
        Collections.sort(li, (o1, o2)->{
            if(o1.x == o2.x) return o1.y - o2.y;
            return o1.x - o2.x;
        });
        for(Point p : li){
            if(here < p.x) here = p.x;
            if(here >= p.y) continue;
            sum += p.y - here;
            here = p.y;
        }
        System.out.println(sum);
    }
}