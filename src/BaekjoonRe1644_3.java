import java.util.*;
import java.io.*;
public class BaekjoonRe1644_3 {
    static int n, sum = 0, cnt = 0, idx = 0, e = 0, s= 0;
    static boolean[] che = new boolean[4000004];
    static int[] a = new int[2000004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 2; i <= n; i++){
            if(che[i]) continue;
            for(int j = 2 * i; j <= n; j += i){
                che[j] = true;
            }
        }
        for(int i = 2; i <= n; i++){
            if(!che[i]) a[idx++] = i;
        }
        while(true){
            if(sum >= n) sum -= a[s++];
            else if(e == idx) break;
            else sum += a[e++];
            if(sum == n) cnt++;
        }
        System.out.println(cnt);
    }
}