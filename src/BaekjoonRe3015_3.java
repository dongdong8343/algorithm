import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe3015_3 {
    static int n;
    static long ret = 0;
    static Stack<Point> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            int cnt = 1;
            while(!st.isEmpty() && st.peek().x <= a) {
                Point p = st.pop();
                ret += p.y;
                if(p.x == a) cnt += p.y;
            }if(!st.isEmpty()) ret++;
            st.push(new Point(a, cnt));
        }
        System.out.println(ret);
    }
}