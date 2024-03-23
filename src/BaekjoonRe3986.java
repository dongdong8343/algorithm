import java.io.*;
import java.util.*;
public class BaekjoonRe3986 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ret = 0;
        for(int i = 0; i < n; i++){
            String word = br.readLine();
            Stack<Character> s = new Stack<>();
            for(char c : word.toCharArray()){
                if(!s.empty()){
                    if(s.peek() == c)
                        s.pop();
                    else
                        s.push(c);
                }
                else s.push(c);
            }
            if(s.empty()) ret++;
        }
        System.out.println(ret);
    }
}
