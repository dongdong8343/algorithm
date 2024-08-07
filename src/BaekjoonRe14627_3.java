import java.util.*;
import java.io.*;
public class BaekjoonRe14627_3 {
    static long n, m, sum, l, h, ret;
    static long[] a = new long[1000004];
    static boolean check(long mid){
        long cnt = 0;
        for(int i = 0; i < n; i++){
            cnt += a[i] / mid;
        }
        return m <= cnt;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }
        l = 1; h = (int)1e9;
        while(l <= h){
            long mid = (l + h) / 2;
            if(check(mid)){
                l = mid + 1;
                ret = mid;
            }else h = mid - 1;
        }
        System.out.println(sum - m * ret);
    }
}