import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe2565_3 {
    static int n, l, h;
    static List<Point> li = new ArrayList<>();
    static List<Integer> a = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            li.add(new Point(x, y));
        }
        Collections.sort(li, (o1, o2) -> o1.x - o2.x);
        a.add(li.get(0).y);
        for(int i = 1; i < li.size(); i++){
            if(li.get(i).y > a.get(a.size() - 1)) a.add(li.get(i).y);
            else{
                l = 0; h = a.size() - 1;
                while(l < h){
                    int mid = (l + h) / 2;
                    if(a.get(mid) >= li.get(i).y) h = mid;
                    else l = mid + 1;
                }
                a.set(h, li.get(i).y);
            }
        }
        System.out.println(n - a.size());
    }
}