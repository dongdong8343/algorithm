import java.util.*;
import java.io.*;
public class BaekjoonRe1644_1 {
    static int n, l = 0, h = 0, pos = 0, sum = 0;
    static long ret = 0;
    static int[] che = new int[4000001];
    static int[] a = new int[2000001];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 2; i <= n; i++){
            if(che[i] == 1) continue;
            for(int j = 2 * i; j <= n; j += i) che[j] = 1;
        }
        for(int i = 2; i <= n; i++) if(che[i] == 0) a[pos++] = i;
        while(true){
            if(sum >= n) sum -= a[l++];
            if(sum < n) sum += a[h++];
            if(sum == n) ret++;
            if(h > pos) break;
        }
        System.out.println(ret);
    }
}