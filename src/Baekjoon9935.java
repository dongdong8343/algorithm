import java.util.*;
import java.io.*;
public class Baekjoon9935 {
    static String word, ex;
    static String ret;
    static Stack<Character> s = new Stack<>();
   public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        ex = br.readLine();
        for(char c : word.toCharArray()){
            s.push(c);
            if(s.size() >= ex.length() && s.peek() == ex.charAt(ex.length() - 1)){
                StringBuilder temp = new StringBuilder();
                for(int i = 0; i < ex.length(); i++)
                    temp.append(s.pop());
                temp.reverse();
                if(!temp.toString().equals(ex)){
                    for(int i = 0; i < ex.length(); i++) s.push(temp.charAt(i));
                }
            }
        }
        if(s.empty()) System.out.println("FRULA");
        else{
            StringBuilder sb = new StringBuilder();
            while(!s.empty()) sb.append(s.pop());
            sb.reverse();
            System.out.println(sb.toString());
        }
    }
}