import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe14003_4 {
    static int n, temp;
    static Point[] a = new Point[1000004];
    static List<Integer> li = new ArrayList<>();
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = new Point(Integer.parseInt(st.nextToken()), 0);
        }
        for(int i = 0; i < n; i++){
            if(i == 0 || li.get(li.size() - 1) < a[i].x) {
                li.add(a[i].x);
                a[i].y = li.size() - 1;
                continue;
            }
            int l = 0, h = li.size() - 1;
            while(l < h){
                int mid = (l + h) / 2;
                if(li.get(mid) >= a[i].x){
                    h = mid;
                }else l = mid + 1;
            }
            li.set(h, a[i].x);
            a[i].y = h;
        }
        System.out.println(li.size());

        temp = li.size() - 1;
        for(int i = n - 1; i >= 0; i--){
            if(temp == a[i].y){
                temp--;
                s.push(a[i].x);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}