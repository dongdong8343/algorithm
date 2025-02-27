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

        int h = max, l = 1;

        while(l < h - 1) {
            int mid = (l + h) / 2;
            if(f(mid, n, a) > m) h = mid;
            else l = mid;
        }
        
        System.out.println(l);
    }

    static int f(int mid, int n, int[] a) {
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += Math.min(mid, a[i]);
        }

        return sum;
    }
}