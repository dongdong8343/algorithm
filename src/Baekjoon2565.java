import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon2565 {
    static int n, l, h;
    static List<Point> a = new ArrayList<>();
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a.add(new Point(x, y));
        }
        Collections.sort(a, (o1, o2) -> {
            return o1.x - o2.x;
        });
        li.add(Integer.MIN_VALUE);
        for(Point p : a){
            if(li.get(li.size() - 1) < p.y) li.add(p.y);
            else{
                l = 1; h = li.size() - 1;
                while(l < h){
                    int mid = (l + h) / 2;
                    if(li.get(mid) >= p.y) h = mid;
                    else l = mid + 1;
                }
                li.set(h, p.y);
            }
        }
        System.out.println(n - li.size() + 1);
    }
}