import java.util.*;
import java.io.*;
public class BaekjoonRe9935_3 {
    static String s, e;
    static Stack<Character> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        e = br.readLine();
        for(int i = 0; i < s.length(); i++){
            st.push(s.charAt(i));
            if(st.peek() == e.charAt(e.length() - 1)){
                if(st.size() >= e.length()){
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < e.length(); j++){
                        sb.append(st.pop());
                    }
                    sb.reverse();
                    if(!sb.toString().equals(e)){
                        for(int j = 0; j < sb.toString().length(); j++){
                            st.push(sb.toString().charAt(j));
                        }
                    }
                }
            }
        }
        if(st.isEmpty()) System.out.println("FRULA");
        else{
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            sb.reverse();
            System.out.println(sb);
        }
    }
}