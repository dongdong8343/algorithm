import java.util.*;
import java.io.*;
public class BaekjoonRe9935 {
    static Stack<Character> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String e = br.readLine();
        for(int i = 0; i < s.length(); i++){
            st.push(s.charAt(i));
            if(st.size() >= e.length() && st.peek() == e.charAt(e.length() - 1)){
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < e.length(); j++) temp.append(st.pop());
                temp.reverse();
                if(!temp.toString().equals(e)){
                    for(int j = 0; j < e.length(); j++) st.push(temp.charAt(j));
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