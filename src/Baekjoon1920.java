import java.io.*;
import java.util.*;
public class Baekjoon1920 {
    public static void main(String[] args)throws Exception{
        HashMap<Integer, Integer> hs = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) hs.put(Integer.parseInt(st.nextToken()), 1);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int t = Integer.parseInt(st.nextToken());
            if(hs.containsKey(t)) System.out.println(1);
            else System.out.println(0);
        }
    }
}