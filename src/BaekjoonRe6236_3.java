import java.io.*;
import java.util.*;
public class BaekjoonRe6236_3 {
    static long n, m, max = -987654321, l, h, ret = 0;
    static long[] a = new long[100004];
    static boolean check(long mid){
        if(max > mid) return false;
        long cnt = 1, temp = mid;
        for(int i = 0; i < n; i++){
            if(mid - a[i] < 0) {
                mid = temp;
                cnt++;
            }
            mid -= a[i];
        }
        return m >= cnt;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, a[i]);
        }
        l = 1; h = (int)1e9;
        while(l <= h){
            long mid = (l + h) / 2;
            if(check(mid)){
                ret = mid;
                h = mid - 1;
            }else l = mid + 1;
        }
        System.out.println(ret);
    }
}