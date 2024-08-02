import java.util.*;
import java.io.*;
public class BaekjoonRe2632_3 {
    static int want, n, m, ret = 0;
    static int[] a = new int[1004];
    static int[] b = new int[1004];
    static int[] asum = new int[2008];
    static int[] bsum = new int[2008];
    static HashMap<Integer, Integer> ant = new HashMap<>();
    static HashMap<Integer, Integer> bnt = new HashMap<>();
    static void go(HashMap<Integer, Integer> cnt, int[] sum, int k){
        for(int i = 1; i <= k; i++){
            for(int j = i; j < k + i; j++){
                int x = sum[j] - sum[j - i];
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
                if(i == k) break;
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
            asum[i] = a[i] + asum[i - 1];
        }
        for(int i = n + 1; i <= 2 * n; i++){
            asum[i] = asum[i - 1] + a[i - n];
        }
        for(int i = 1; i <= m; i++){
            b[i] = Integer.parseInt(br.readLine());
            bsum[i] = b[i] + bsum[i - 1];
        }
        for(int i = m + 1; i <= 2 * m; i++){
            bsum[i] = bsum[i - 1] + b[i - m];
        }
        go(ant, asum, n);
        go(bnt, bsum, m);
        ret = ant.getOrDefault(want, 0) + bnt.getOrDefault(want, 0);
        for(int i = 1; i < want; i++){
            ret += ant.getOrDefault(i, 0) * bnt.getOrDefault(want - i, 0);
        }
        System.out.println(ret);
    }
}