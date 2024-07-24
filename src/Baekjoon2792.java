import java.util.*;
import java.io.*;
public class Baekjoon2792 {
    static long n, m, h = 0, l = 1, ret = 1987654321;
    static long[] a = new long[300004];
    static boolean check(long mid){
        long cnt = 0;
        for(int i = 0; i < m; i++){
            cnt += a[i] / mid;
            if(a[i] % mid != 0) cnt++;
        }
        return n >= cnt;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        for(int i = 0; i < m; i++){
            long x = Long.parseLong(br.readLine());
            a[i] = x;
            h = Math.max(h, x);
        }
        while(l <= h){
            long mid = (l + h) / 2;
            if(check(mid)){
                h = mid - 1;
                ret = Math.min(ret, mid);
            }else l = mid + 1;
        }
        System.out.println(ret);
    }
}