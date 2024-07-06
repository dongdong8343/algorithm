import java.util.*;
import java.io.*;
public class BaekjoonRe9935_2 {
    static Stack<Character> st = new Stack<>();
    static String word, e;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        e = br.readLine();
        for(int s = 0; s < word.length(); s++){
            st.push(word.charAt(s));
            if(st.size() >= e.length() && st.peek() == e.charAt(e.length() - 1)){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < e.length(); i++) sb.append(st.pop());
                sb.reverse();
                if(!sb.toString().equals(e)){
                    for(char c : sb.toString().toCharArray()) st.push(c);
                }
            }
        }
        if(st.isEmpty()) System.out.println("FRULA");
        else{
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()) sb.append(st.pop());
            sb.reverse();
            System.out.println(sb);
        }
    }
}