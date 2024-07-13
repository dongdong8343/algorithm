import java.util.*;
import java.io.*;
public class BaekjoonRe1285_7 {
    static int n, min = 987654321;
    static int[] a = new int[24];
    static void go(int idx){
        if(idx == n){
            int sum = 0;
            for(int i = 0; i < n; i++){
                int cnt = 0;
                for(int j = 0; j < n; j++){
                    if((a[i] & (1 << j)) != 0) cnt++;
                }
                sum += Math.min(cnt, n - cnt);
            }
            min = Math.min(min, sum);
            sum = 0;
            for(int i = 0; i < n; i++){
                int cnt = 0;
                for(int j = 0; j < n; j++){
                    if((a[j] & (1 << i)) != 0) cnt++;
                }
                sum += Math.min(cnt, n - cnt);
            }
            min = Math.min(min, sum);
            return;
        }
        go(idx + 1);
        a[idx] = ~a[idx];
        go(idx + 1);
        a[idx] = ~a[idx];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i =  0; i < n; i++){
            String s = br.readLine();
            for(int j =  0; j < n; j++){
                char c = s.charAt(j);
                if(c == 'T') a[i] |= (1 << j);
            }
        }
        go(0);
        System.out.println(min);
    }
}