import java.io.*;
import java.util.*;

public class Baekjoon2512 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(br.readLine());

        int[] a  = new int[n + 4];
        int sum = 0, max = -987654321, ret = 0;

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, a[i]);
            sum += a[i];
        }

        if(sum <= m) {
            System.out.println(max);
            return;
        }

        outer:
        for(int i = max; i > 0; i--) {
            sum = 0;
            ret = -987654321;
            
            for(int j = 0; j < n; j++) {
                if(i >= a[j]) {
                    sum += a[j];
                    if(sum > m) continue outer;
                    ret = Math.max(ret, a[j]);
                } else {
                    sum += i;
                    ret = Math.max(ret, i);
                }
            }

            if(sum > m) continue outer;
            else break;
        }
        
        System.out.println(ret);
    }
}