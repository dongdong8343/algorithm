import java.util.*;
import java.io.*;
public class Baekjoon4949_1 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            if(s.charAt(0) == '.') break;
            Stack<Character> st = new Stack<>();
            boolean error = false;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '(' || c == '[') st.push(c);
                else if(c == ')' && !st.isEmpty()){
                    if(st.peek() == '(') st.pop();
                    else {
                        error = true;
                        break;
                    }
                }else if(c == ']' && !st.isEmpty()){
                    if(st.peek() == '[') st.pop();
                    else {
                        error = true;
                        break;
                    }
                }else if((c == ']' || c == ')')){
                    error = true;
                    break;
                }
            }
            if(error || !st.isEmpty()) System.out.println("no");
            else System.out.println("yes");
        }
    }
}