import java.util.*;
import java.io.*;
public class BaekjoonRe2343_3 {
    static long n, m, l, h, ret = 0, max = -987654321;
    static long[] a = new long[100004];
    static boolean check(long mid){
        if(max > mid) return false;
        long cnt = 1, temp = mid;
        for(int i = 0; i < n; i++){
            if(mid - a[i] < 0){
                mid = temp;
                cnt++;
            }
            mid -= a[i];
        }
        return cnt <= m;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
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