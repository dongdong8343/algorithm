import java.util.*;
import java.io.*;
public class Baekjoon1285 {
    static int n, ret = 987654321;
    static int[] a = new int[44];
    static void go(int here){
        if(here == n){
            int min = 0;
            for(int i = 1; i < (1 << n); i *= 2){
                int cnt = 0;
                for(int j = 0; j < n; j++){
                    if((a[j] & i) != 0) cnt++;
                }
                min += Math.min(cnt, n - cnt);
            }
            ret = Math.min(ret, min);
            return;
        }
        go(here + 1);
        a[here] = ~a[here];
        go(here + 1);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            int idx = 0;
            for(int j = 0; j < n; j++){
                char c = s.charAt(j);
                if(c == 'T') a[i] |= (1 << idx);
                idx++;
            }
        }
        go(0);
        System.out.println(ret);
    }
}