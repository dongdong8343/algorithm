import java.util.*;
import java.io.*;
public class Baekjoon11655 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            int n;
            if(c >= 'A' && c <= 'Z'){
                n = c + 13;
                if(n > 'Z') n -= 26;
                c = (char)n;
            }
            if(c >= 'a' && c <= 'z'){
                n = c + 13;
                if(n > 'z') n -= 26;
                c = (char)n;
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
