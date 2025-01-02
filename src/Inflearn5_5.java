import java.util.*;
import java.io.*;

public class Inflearn5_5 {
    static Stack<Character> st = new Stack<>();
    static int ret = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                if(s.charAt(i + 1) == ')'){
                    ret += st.size();
                    i++;
                }
                else st.push(')');
            }else{
                st.pop();
                ret++;
            }
        }

        System.out.println(ret);

        return ;
    }
}