import java.util.*;
import java.io.*;
public class Baekjoon10773 {
    static int n, sum = 0;
    static Stack<Integer> st = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            int a = Integer.parseInt(br.readLine());
            if(a == 0 && !st.isEmpty()) st.pop();
            else st.push(a);
        }
        while(!st.isEmpty()) sum += st.pop();
        System.out.println(sum);
    }
}