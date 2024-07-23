import java.util.*;
import java.io.*;
public class BaekjoonRe2632_1 {
    static int n, a, b, ret = 0;
    static int[] anum = new int[1004];
    static int[] bnum = new int[1004];
    static int[] asum = new int[2008];
    static int[] bsum = new int[2008];
    static HashMap<Integer, Integer> ant = new HashMap<>();
    static HashMap<Integer, Integer> bnt = new HashMap<>();
    static void go(int[] sum, int t, HashMap<Integer, Integer> cnt){
        for(int i = 1; i <= t; i++){
            for(int j = i; j <= t + i - 1; j++){
                int temp = sum[j] - sum[j - i];
                cnt.put(temp, cnt.getOrDefault(temp, 0) + 1);
                if(i == t) break;
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= a; i++){
            anum[i] = Integer.parseInt(br.readLine());
            asum[i] = asum[i - 1] + anum[i];
        }
        for(int i = a + 1; i <= 2 * a; i++){
            asum[i] = asum[i - 1] + anum[i - a];
        }
        for(int i = 1; i <= b; i++){
            bnum[i] = Integer.parseInt(br.readLine());
            bsum[i] = bsum[i - 1] + bnum[i];
        }
        for(int i = b + 1; i <= 2 * b; i++){
            bsum[i] = bsum[i - 1] + bnum[i - b];
        }
        go(asum, a, ant);
        go(bsum, b, bnt);
        ret += ant.getOrDefault(n, 0);
        ret += bnt.getOrDefault(n, 0);
        for(int i = 1; i <= n; i++){
            ret += ant.getOrDefault(i, 0) * bnt.getOrDefault(n - i, 0);
        }
        System.out.println(ret);
    }
}