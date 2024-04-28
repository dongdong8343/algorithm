import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;
public class Baekjoon15686 {
    static List<Point> house = new ArrayList<>();
    static List<Point> chi = new ArrayList<>();
    static List<Point> chose = new ArrayList<>();
    static int n, m;
    static int ret = 2147400000, tot = 0, min = 10000;
    static void solve(){
        for(Point p1 : house){
            min = 10000;
            for(Point p2 : chose){
                int temp = Math.abs((p1.x + 1) - (p2.x + 1)) + Math.abs((p1.y + 1) - (p2.y + 1));
                min = Math.min(min, temp);
            }
            tot += min;
        }
        ret = Math.min(tot, ret);
        tot = 0;
    }
    static void combi(int start){
        if(chose.size() == m){
            solve();
            return;
        }
        for(int i = start; i < chi.size(); i++){
            chose.add(chi.get(i));
            combi(i);
            chose.remove(chose.size() - 1);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1)
                    house.add(new Point(i, j));
                else if(temp == 2)
                    chi.add(new Point(i, j));
            }
        }
        combi(0);
        System.out.println(ret);
    }
}
