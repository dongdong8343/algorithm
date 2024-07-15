import java.util.*;
import java.io.*;
public class Baekjoon10815 {
    static HashMap<Integer, Integer> hs = new HashMap<>();
    static int n, k;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            hs.put(a, 1);
        }
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            int a = Integer.parseInt(st.nextToken());
            if(hs.containsKey(a)) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}