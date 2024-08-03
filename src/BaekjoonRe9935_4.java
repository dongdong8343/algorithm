import java.util.*;
import java.io.*;
public class BaekjoonRe9935_4 {
    static Stack<Character> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String e = br.readLine();
        for(char c : s.toCharArray()){
            st.push(c);
            if(st.size() >= e.length() && st.peek() == e.charAt(e.length() - 1)){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < e.length(); i++){
                    sb.append(st.pop());
                }
                sb.reverse();
                if(!e.contentEquals(sb)){
                    for(char x : sb.toString().toCharArray()) st.push(x);
                }
            }
        }
        if(st.isEmpty()) System.out.println("FRULA");
        else{
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()) sb.append(st.pop());
            sb.reverse();
            System.out.println(sb.toString());
        }
    }
}