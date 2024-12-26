import java.util.*;
import java.io.*;

public class InflearnRe5_4 {
    static Stack<Integer> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                st.push(Integer.parseInt(String.valueOf(c)));
            }else{
                int b = st.pop(); int a = st.pop();
                int temp;
                if(c == '+') temp = a + b;
                else if(c == '-') temp = a - b;
                else if(c == '*') temp = a * b;
                else temp = a / b;
                st.push(temp);
            }
        }

        System.out.println(st.pop());

        return ;
    }
}