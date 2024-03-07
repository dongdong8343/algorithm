import java.util.*;
import java.io.*;
public class Baekjoon10828 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int temp = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] str = new String[2];
            str[0] = st.nextToken();

            if(str[0].equals("push")){
                str[1] = st.nextToken();
                stack.push(Integer.parseInt(str[1]));
            }else if(str[0].equals("pop")){
                if(!stack.empty())
                    System.out.println(stack.pop());
                else
                    System.out.println(-1);
            }else if(str[0].equals("size")) {
                System.out.println(stack.size());
            }else if(str[0].equals("empty")) {
                if (stack.empty()) {
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            } else if (str[0].equals("top")) {
                if(!stack.empty())
                    System.out.println(stack.peek());
                else
                    System.out.println(-1);
            }
        }
    }
}
