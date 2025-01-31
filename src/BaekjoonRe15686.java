import java.io.*;
import java.util.*;
import java.awt.Point;

public class BaekjoonRe15686 {
    static int n, m, cnt = 0, ret = 987654321;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static List<Point> v = new ArrayList<>();

    static void go(int s){
        if(v.size() == m){
            cal();
            return;
        }
        for(int i = s + 1; i < cnt; i++){
            v.add(chickens.get(i));
            go(i);
            v.remove(chickens.get(i));
        }
    }

    static void cal(){
        int sum = 0;
        for(Point h : houses){
            int dist = 987654321;
            for(Point c : v){
                dist = Math.min(dist, Math.abs(c.y - h.y) + Math.abs(c.x - h.x));
            }
            sum += dist;
            if(ret < sum) return;
        }
        ret = Math.min(ret, sum);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        for(int i = 0; i < n; i++){
            s = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                if(Integer.parseInt(s[j]) == 1) houses.add(new Point(j, i));
                else if(Integer.parseInt(s[j]) == 2) {
                    chickens.add(new Point(j, i));
                    cnt++;
                }
            }
        }

        go(-1);

        System.out.println(ret);
    }
}