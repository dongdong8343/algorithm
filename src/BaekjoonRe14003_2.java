import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe14003_2 {
    static int n, l, h;
    static List<Point> li = new ArrayList<>();
    static List<Integer> a = new ArrayList<>();
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            li.add(new Point(Integer.parseInt(st.nextToken()), 0));
        }
        a.add(-1987654321);
        for(int i = 0; i < n; i++){
            if(a.get(a.size() - 1) < li.get(i).x){
                a.add(li.get(i).x);
                li.set(i, new Point(li.get(i).x, a.size() - 1));
            }else{
                l = 1; h = a.size() - 1;
                while(l < h){
                    int mid = (l + h) / 2;
                    if(a.get(mid) >= li.get(i).x){
                        h = mid;
                    }else l = mid + 1;
                }
                a.set(h, li.get(i).x);
                li.set(i, new Point(li.get(i).x, h));
            }
        }
        System.out.println(a.size() - 1);
        int idx = a.size() - 1;
        for(int i = li.size() - 1; i >= 0; i--){
            if(idx == li.get(i).y) {
                s.push(li.get(i).x);
                idx--;
            }
        }
        while(!s.isEmpty()) sb.append(s.pop()).append(' ');
        System.out.println(sb);
    }
}