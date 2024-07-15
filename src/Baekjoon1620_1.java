import java.util.*;
import java.io.*;
public class Baekjoon1620_1 {
    static int n, m;
    static HashMap<String, Integer> hs = new HashMap<>();
    static HashMap<Integer, String> hs1 = new HashMap<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            String s = br.readLine();
            hs.put(s, i);
            hs1.put(i, s);
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < m; j++){
            String s = br.readLine();
            if(hs.containsKey(s)) sb.append(hs.get(s)).append("\n");
            else sb.append(hs1.get(Integer.parseInt(s))).append("\n");
        }
        System.out.println(sb);
    }
}