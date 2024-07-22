import java.util.*;
import java.io.*;

public class Baekjoon2632 {
    static int want, n, m, ret = 0;
    static int[] a = new int[1004];
    static int[] b = new int[1004];
    static int[] pSum_a = new int[2008];
    static int[] pSum_b = new int[2008];
    static HashMap<Integer, Integer> ant = new HashMap<>();
    static HashMap<Integer, Integer> bnt = new HashMap<>();
    static void go(int n, int[] psum, HashMap<Integer, Integer> hs){
        for(int i = 1; i <= n; i++){
            for(int j = i; j <= n + i - 1; j++){
                int sum = psum[j] - psum[j - i];
                hs.put(sum, hs.getOrDefault(sum, 0) + 1);
                if(i == n) break;
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        want = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(br.readLine());
            pSum_a[i] = pSum_a[i - 1] + a[i];
        }

        for(int i = n + 1; i <= 2 * n; i++)
            pSum_a[i] = pSum_a[i - 1] + a[i - n];

        for(int i = 1; i <= m; i++){
            b[i] = Integer.parseInt(br.readLine());
            pSum_b[i] = pSum_b[i - 1] + b[i];
        }

        for(int i = m + 1; i <= 2 * m; i++)
            pSum_b[i] = pSum_b[i - 1] + b[i - m];

        go(n, pSum_a, ant);
        go(m, pSum_b, bnt);
        ret = (ant.getOrDefault(want, 0) + bnt.getOrDefault(want, 0));
        for(int i = 1; i <= want; i++){
            ret += (ant.getOrDefault(i, 0) * bnt.getOrDefault(want - i, 0));
        }
        System.out.println(ret);
    }
}
