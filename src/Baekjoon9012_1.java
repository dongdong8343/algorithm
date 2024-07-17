import java.util.*;
import java.io.*;
public class Baekjoon9012_1 {
    static int n;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            Stack<Character> st = new Stack<>();
            String s = br.readLine();
            boolean error = false;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '(') st.push('(');
                else if(!st.isEmpty()) st.pop();
                else {
                    error = true;
                    break;
                }
            }
            if(!st.isEmpty() || error) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}