import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe2565_3 {
    static int n, l, h;
    static List<Point> arr = new ArrayList<>();
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Point(a, b));
        }
        Collections.sort(arr, (o1, o2) -> {
            return o1.x - o2.x;
        });
        li.add(arr.get(0).y);
        for(int i = 1; i < n; i++){
            int x = arr.get(i).y;
            if(li.get(li.size() - 1) < x) li.add(x);
            else{
                l = 0; h = li.size() - 1;
                while(l < h){
                    int mid = (l + h) / 2;
                    if(li.get(mid) >= x) {
                        h = mid;
                    }else l = mid + 1;
                }
                li.set(h, x);
            }
        }
        System.out.println(n - li.size());
    }
}