import java.util.*;
import java.io.*;
public class Baekjoon3986 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            Stack<Character> st = new Stack<>();
            if(word.length() % 2 != 0) continue;
            for(char c : word.toCharArray()){
                if(!st.empty() && c == st.peek()) st.pop();
                else st.push(c);
            }
            if(st.empty()) cnt++;
        }
        System.out.println(cnt);
    }
}
