import java.util.*;
import java.io.*;

public class Inflearn4_3 {
    static int n, k, rt, lt = 0;
    static int[] a = new int[100004];
    static HashMap<Integer, Integer> hs = new HashMap<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < k; i++) hs.put(a[i], hs.getOrDefault(a[i], 0) + 1);
        System.out.print(hs.size() + " ");
        rt = k;

        while(rt < n){
            hs.put(a[lt], hs.get(a[lt]) - 1);
            if(hs.get(a[lt]) == 0) hs.remove(a[lt]);
            hs.put(a[rt], hs.getOrDefault(a[rt], 0) + 1);
            System.out.print(hs.size() + " ");
            lt++; rt++;
        }

        return;
    }
}
