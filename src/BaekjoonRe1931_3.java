import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe1931_3 {
    static int n, cnt = 0;
    static List<Point> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            li.add(new Point(s, e));
        }
        Collections.sort(li, (o1, o2) -> {
            if(o1.y == o2.y) return o1.x - o2.x;
            return o1.y - o2.y;
        });
        int e = 0;
        for(int i = 0; i < n; i++){
            if(e <= li.get(i).x){
                cnt++;
                e = li.get(i).y;
            }
        }
        System.out.println(cnt);
    }
}