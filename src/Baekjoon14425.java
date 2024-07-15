import java.util.*;
import java.io.*;
public class Baekjoon14425 {
    static int cnt = 0;
    static HashMap<String, Integer> hs = new HashMap<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        while(n-- > 0){
            String s= br.readLine();
            hs.put(s, 1);
        }
        while(m-- > 0){
            String s= br.readLine();
            if(hs.containsKey(s)) cnt++;
        }
        System.out.println(cnt);
    }
}