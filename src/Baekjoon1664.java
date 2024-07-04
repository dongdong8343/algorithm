import java.util.*;
import java.io.*;
public class Baekjoon1664 {
    static int n, p = 0, ret = 0, sum = 0, lo = 0, hi = 0;
    static boolean[] che = new boolean[4000001];
    static int[] a = new int[2000001];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 2; i <= n; i++){
            if(che[i]) continue;
            for(int j = 2 * i; j <= n; j += i)
                che[j] = true;
        }
        for(int i = 2; i <= n; i++)
            if(!che[i]) a[p++] = i;
        while(true){
            if(sum >= n) sum -= a[lo++];
            else if(hi == p) break;
            else sum += a[hi++];
            if(sum == n) ret++;
        }
        System.out.println(ret);
    }
}