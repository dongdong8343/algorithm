import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe2565_4 {
    static int n;
    static List<Point> li = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
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
            return o1.x - o2.x;
        });
        for(int i = 0; i < n; i++){
            if(temp.isEmpty() || temp.get(temp.size() - 1) < li.get(i).y) temp.add(li.get(i).y);
            else{
                int l = 0, h = temp.size() - 1;
                while(l < h){
                    int mid = (l + h) / 2;
                    if(temp.get(mid) >= li.get(i).y) h = mid;
                    else l = mid + 1;
                }
                temp.set(h, li.get(i).y);
            }
        }
        System.out.println(n - temp.size());
    }
}