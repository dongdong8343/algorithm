import java.util.*;
import java.io.*;
public class Baekjoon1269 {
    static int n, m, cnt = 0;
    static HashMap<Integer, Integer> hs1 = new HashMap<>();
    static HashMap<Integer, Integer> hs2 = new HashMap<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            hs1.put(a, 1);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            hs2.put(a, 1);
        }
        for(int x : hs1.keySet()){
            if(!hs2.containsKey(x)) cnt++;
        }
        for(int x : hs2.keySet()){
            if(!hs1.containsKey(x)) cnt++;
        }
        System.out.println(cnt);
    }
}