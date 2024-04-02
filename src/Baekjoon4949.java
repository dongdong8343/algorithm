import java.util.*;
import java.io.*;
public class Baekjoon4949 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            if(s.equals("."))
                break;
            Stack<Character> st = new Stack<>();
            for(char c : s.toCharArray())
                if(c == '(' || c == '[' || c == ')' || c == ']'){
                    if(!st.empty() && c == ')'){
                        if(st.peek() == '('){
                            st.pop();
                            continue;
                        }
                    }
                    else if(!st.empty() && c == ']'){
                        if(st.peek() == '['){
                            st.pop();
                            continue;
                        }
                    }
                    st.push(c);
                }
            if(!st.empty())
                System.out.println("no");
            else
                System.out.println("yes");
        }
    }
}
