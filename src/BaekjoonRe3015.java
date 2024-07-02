import java.awt.*;
import java.util.*;
import java.io.*;
public class BaekjoonRe3015 {
    static int n;
    static long ret = 0;
    static Stack<Point> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            int cnt = 1;
            while(!st.empty() && st.peek().y <= a){
                ret += st.peek().x;
                if(st.peek().y == a) {
                    cnt += st.peek().x;
                }
                st.pop();
            }
            if(!st.empty()) ret++;
            st.push(new Point(cnt, a));
        }
        System.out.println(ret);
    }
}