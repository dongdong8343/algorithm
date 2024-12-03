import java.util.*;
import java.io.*;

public class Inflearn5_2 {
    static String s;
    static Stack<Character> st = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for(char c : s.toCharArray()){
            if(c == '(') st.push(c);
            else if(c == ')') st.pop();
            else{
                if(st.isEmpty()) sb.append(c);
            }
        }

        System.out.println(sb.toString());

        return;
    }
}