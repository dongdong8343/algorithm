import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe14003_3 {
    static int n;
    static Point[] a = new Point[1000004];
    static List<Integer> li = new ArrayList<>();
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(st.nextToken());
            a[i] = new Point(x, 0);
        }
        li.add(a[0].x);
        for(int i = 1; i < n; i++){
            int x = a[i].x;
            if(li.get(li.size() - 1) < x){
                li.add(x);
                a[i] = new Point(x, li.size() - 1);
            }else{
                int l = 0; int h = li.size() - 1;
                while(l < h){
                    int mid = (l + h) / 2;
                    if(li.get(mid) >= x){
                        h = mid;
                    }else l = mid + 1;
                }
                li.set(h, x);
                a[i] = new Point(x, h);
            }
        }
        System.out.println(li.size());
        int idx = li.size() - 1;
        for(int i = n - 1; i >= 0; i--){
            if(a[i].y == idx){
                s.push(a[i].x);
                idx--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) sb.append(s.pop()).append(" ");
        System.out.println(sb);

    }
}