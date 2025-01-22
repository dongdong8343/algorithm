import java.io.*;
import java.util.*;
import java.awt.Point;

public class BaekjoonRe11650 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Point> li = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] temp = br.readLine().split(" ");
            li.add(new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }

        Collections.sort(li, (o1, o2) -> {
            if(o1.x == o2.x) return o1.y - o2.y;
            return o1.x - o2.x;
        });

        for(Point p : li){
            System.out.println(p.x + " " + p.y);
        }


    }
}