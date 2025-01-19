import java.io.*;
import java.util.*;
public class BaekjoonRe10828 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String ans = st.nextToken();
            if(ans.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                s.push(x);
            }else if(ans.equals("pop")){
                if(s.isEmpty()) System.out.println(-1);
                else System.out.println(s.pop());
            }else if(ans.equals("size")) System.out.println(s.size());
            else if(ans.equals("empty")) {
                if (s.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }else if(ans.equals("top")){
                if (s.isEmpty()) System.out.println(-1);
                else System.out.println(s.peek());
            }
        }
    }
}