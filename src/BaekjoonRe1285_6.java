import java.util.*;
import java.io.*;
public class BaekjoonRe1285_6 {
    static int n, ret = 987654321;
    static int[] map;
    static void go(int here){
        if(here == n){
            int min = 0;
            for(int i = 1; i < (1 << n); i *= 2){
                int cnt = 0;
                for(int j = 0; j < n; j++){
                    if((map[j] & i) != 0) cnt++;
                }
                min += Math.min(cnt, n - cnt);
            }
            ret = Math.min(ret, min);
            return;
        }
        go(here + 1);
        map[here] = ~map[here];
        go(here + 1);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 4];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                if(s.charAt(j) == 'T') map[i] |= (1 << j);
            }
        }
        go(0);
        System.out.println(ret);
    }
}