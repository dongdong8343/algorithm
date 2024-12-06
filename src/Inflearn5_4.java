import java.util.*;
import java.io.*;

public class Inflearn5_4 {
    static Stack<Integer> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) st.push(Integer.parseInt(String.valueOf(c)));
            else{
                int t1 = st.pop();
                int t2 = st.pop();
                int temp;
                if(c == '+') temp = t2 + t1;
                else if(c == '-') temp = t2 - t1;
                else if(c == '*') temp = t2 * t1;
                else temp = t2 / t1;
                st.push(temp);
            }
        }

        System.out.println(st.pop());


        return ;
    }
}