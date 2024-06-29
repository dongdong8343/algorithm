import java.util.*;
import java.io.*;
public class BaekjoonReReReReRe1285 {
    static int n, ret = 987654321;
    static int[] map = new int[24];
    static void go(int idx){
        if(idx == n){
            int sum = 0;
            for(int i = 0; i < n; i++){
                int cnt = 0;
                for(int j = 0; j < n; j++){
                    if((map[j] & (1 << i)) != 0) cnt++;
                }
                sum += Math.min(n - cnt, cnt);;
            }
            ret = Math.min(ret, sum);
            return;
        }
        go(idx + 1);
        map[idx] = ~map[idx];
        go(idx + 1);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                char c = s.charAt(j);
                if(c == 'T') map[i] |= (1 << j);
            }
        }
        go(0);
        System.out.println(ret);
    }
}