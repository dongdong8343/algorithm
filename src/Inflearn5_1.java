import java.util.*;
import java.io.*;

public class Inflearn5_1 {
    static String s;
    static Stack<Character> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        for(char c : s.toCharArray()){
            if(c == '(') st.push(c);
            else{
                if(!st.isEmpty()) st.pop();
                else{
                    System.out.println("NO");
                    return;
                }
            }
        }

        if(!st.isEmpty()) System.out.println("NO");
        else System.out.println("YES");

        return;
    }
}