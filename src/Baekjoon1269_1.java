import java.util.*;
import java.io.*;
public class Baekjoon1269_1 {
    static int n, m, ret = 0;
    static HashMap<Integer, Integer> hs1 = new HashMap<>();
    static HashMap<Integer, Integer> hs2 = new HashMap<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) hs1.put(Integer.parseInt(st.nextToken()), 1);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) hs2.put(Integer.parseInt(st.nextToken()), 1);

        for(int x : hs1.keySet()){
            if(!hs2.containsKey(x)) ret++;
        }
        for(int x : hs2.keySet()){
            if(!hs1.containsKey(x)) ret++;
        }

        System.out.println(ret);
    }
}