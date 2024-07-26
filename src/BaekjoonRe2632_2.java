import java.util.*;
import java.io.*;
public class BaekjoonRe2632_2 {
    static int want, n, m, x, ret = 0;
    static int[] a = new int[2004];
    static int[] b = new int[2004];
    static int[] num = new int[2004];
    static HashMap<Integer, Integer> ant = new HashMap<>();
    static HashMap<Integer, Integer> bnt = new HashMap<>();
    static void go(int c, int[] a, HashMap<Integer, Integer> hs){
        for(int i = 1; i <= c; i++){
            for(int j = i; j < c + i; j++){
                int x = a[j] - a[j - i];
                hs.put(x, hs.getOrDefault(x, 0) + 1);
                if(i == c) break;
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
            x = Integer.parseInt(br.readLine());
            a[i] = a[i - 1] + x;
            num[i] = x;
        }
        for(int i = n + 1; i <= 2 * n; i++){
            a[i] = a[i - 1] + num[i - n];
        }
        for(int i = 1; i <= m; i++){
            x = Integer.parseInt(br.readLine());
            b[i] = b[i - 1] + x;
            num[i] = x;
        }
        for(int i = m + 1; i <= 2 * m; i++){
            b[i] = b[i - 1] + num[i - m];
        }
        go(n, a, ant);
        go(m, b, bnt);
        ret = ant.getOrDefault(want, 0) + bnt.getOrDefault(want, 0);

        for(int i = 1; i < want; i++){
            ret += ant.getOrDefault(i, 0) * bnt.getOrDefault(want - i, 0);
        }
        System.out.println(ret);
    }
}