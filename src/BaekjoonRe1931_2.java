import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe1931_2 {
    static int n;
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
        Collections.sort(li, (o1, o2)->{
            if(o1.y == o2.y) return o1.x - o2.x;
            return o1.y - o2.y;
        });
        int ret = 1;
        int t = li.get(0).y;
        for(int i = 1; i < n; i++){
            if(li.get(i).x >= t){
                ret++;
                t = li.get(i).y;
            }
        }
        System.out.println(ret);
    }
}