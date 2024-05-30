import java.util.*;
import java.io.*;
public class BaekjoonReRe1285 {
    static int n, ret = 987654321;
    static int[] map = new int[42];
    static void go(int here){
        if(here == n){
            int temp = 0;
            for(int i = 0; i < n; i++){
                int cnt = 0;
                for(int j = 0; j < n; j++){
                    if((map[j] & (1 << i)) != 0) cnt++;
                }
                temp += Math.min(cnt, n - cnt);
            }
            ret = Math.min(ret, temp);
            return;
        }
        go(here + 1);
        map[here] = ~map[here];
        go(here + 1);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                char a = s.charAt(j);
                if(a == 'T') map[i] |= (1 << j);
            }
        }
        go(0);
        System.out.println(ret);
    }
}