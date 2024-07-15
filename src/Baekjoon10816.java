import java.util.*;
import java.io.*;
public class Baekjoon10816 {
    static int n, m;
    static HashMap<Integer, Integer> hs = new HashMap<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            if(hs.containsKey(a)) {
                int cnt = hs.get(a);
                hs.replace(a, ++cnt);
            }else{
                hs.put(a, 1);
            }
        }
        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int a = Integer.parseInt(st.nextToken());
            if(hs.containsKey(a)) sb.append(hs.get(a)).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}