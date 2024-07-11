import java.util.*;
import java.io.*;
public class Baekjoon2745 {
    static int ret = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int idx = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            int a;
            if(c >= 'A' && c <= 'Z') a = 10 + (c - 'A');
            else a = Integer.parseInt(String.valueOf(c));
            ret += a * (int)Math.pow(b, idx);
            idx++;
        }
        System.out.println(ret);
    }
}