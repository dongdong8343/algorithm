import java.util.*;
import java.io.*;
public class Baekjoon1316 {
    static int n, cnt = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            int[] v = new int[26];
            char last = s.charAt(0);
            v[last - 'a'] = 1;
            boolean no = false;
            for(int j = 1; j < s.length(); j++){
                char c = s.charAt(j);
                if(last != c && v[c - 'a'] == 0){
                    v[c - 'a'] = 1;
                    last = c;
                }else if(last != c && v[c - 'a'] == 1){
                    no = true;
                    break;
                }
            }
            if(!no) cnt++;
        }
        System.out.println(cnt);
    }
}