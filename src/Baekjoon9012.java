import java.io.*;
import java.util.*;
public class Baekjoon9012 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            Stack<Character> st = new Stack<>();
            for(char c: s.toCharArray()){
                if(!st.empty()){
                    if(c == ')' && st.peek() == '('){
                        st.pop();
                        continue;
                    }
                }
                st.push(c);
            }
            if(!st.empty())
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
