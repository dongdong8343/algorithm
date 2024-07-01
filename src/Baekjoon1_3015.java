import java.io.*;
import java.util.*;
import java.awt.Point;
public class Baekjoon1_3015 {
    static int n;
    static long ret = 0;
    static Stack<Point> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            int cnt = 1;
            while(!st.empty() && st.peek().x <= temp){
                Point p = st.pop();
                ret += p.y;
                if(p.x == temp) cnt += p.y;
            }
            if(!st.empty()) ret++;
            st.push(new Point(temp, cnt));
        }
        System.out.println(ret);
    }
}