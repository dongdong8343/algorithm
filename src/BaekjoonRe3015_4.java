import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe3015_4 {
    static long n, ret = 0;
    static int[] a = new int[500004];
    static Stack<Point> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < n; i++){
            int cnt = 1;
            while(!st.isEmpty() && st.peek().x <= a[i]) {
                Point p = st.pop();
                ret += p.y;
                if(p.x == a[i]) cnt += p.y;
            }if(!st.isEmpty()) ret++;
            st.push(new Point(a[i], cnt));
        }
        System.out.println(ret);
    }
}