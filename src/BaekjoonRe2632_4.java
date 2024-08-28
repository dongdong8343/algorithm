import java.util.*;
import java.io.*;
public class BaekjoonRe2632_4 {
    static int want, n, m, ret = 0;
    static int[] a = new int[2008];
    static int[] a1 = new int[1004];
    static int[] b = new int[2008];
    static int[] b1 = new int[1004];
    static HashMap<Integer, Integer> hs1 = new HashMap<>();
    static HashMap<Integer, Integer> hs2 = new HashMap<>();
    static HashMap<Integer, Integer> get(int num, int[] t){
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i = 1; i <= num; i++){
            for(int j = i; j < num + i; j++){
                int x = t[j] - t[j - i];
                hs.put(x, hs.getOrDefault(x, 0) + 1);
                if(i == num) return hs;
            }
        }
        return hs;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        want = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) {
            int x = Integer.parseInt(br.readLine());
            a[i] = a[i - 1] + x;
            a1[i] = x;
        }
        for(int i = n + 1; i <= 2 * n; i++){
            a[i] = a[i - 1] + a1[i - n];
        }
        for(int i = 1; i <= m; i++) {
            int x = Integer.parseInt(br.readLine());
            b[i] = b[i - 1] + x;
            b1[i] = x;
        }
        for(int i = m + 1; i <= 2 * m; i++){
            b[i] = b[i - 1] + b1[i - m];
        }
        hs1 = get(n, a);
        hs2 = get(m, b);
        ret = hs1.getOrDefault(want, 0) + hs2.getOrDefault(want, 0);
        for(int i = 1; i < want; i++){
            ret += hs1.getOrDefault(i, 0) * hs2.getOrDefault(want - i, 0);
        }
        System.out.println(ret);
    }
}