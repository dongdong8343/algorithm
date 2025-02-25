import java.awt.Point;
import java.io.*;
import java.util.*;

public class Baekjoon1931_2 {
    public static void main(String[] args)throws Exception{
        List<Point> li = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            li.add(new Point(s, e));
        }

        Collections.sort(li, (a, b) -> {
            if(a.y == b.y) return a.x - b.x;
            return a.y - b.y;
        });

        int e = li.get(0).y, ret = 1;

        for(int i = 1; i < li.size(); i++){
            int temp = li.get(i).x;
            if(e <= temp) {
                ret++;
                e = li.get(i).y;
            }
        }

        System.out.println(ret);
    }
}