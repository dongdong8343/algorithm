import java.util.*;
import java.io.*;
public class BaekjoonRe2343_4 {
    static int n, m, max = -987654321;
    static long ret, l, h;
    static int[] a = new int[100004];
    static boolean check(long mid){
        if(max > mid) return false;
        long cnt = 1, time = mid;
        for(int i = 0; i < n; i++){
            if(time - a[i] < 0) {
                time = mid;
                cnt++;
            }
            time -= a[i];
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
        l = 1; h = (long)1e9;
        while(l <= h){
            long mid = (l + h) / 2;
            if(check(mid)){
                h = mid - 1;
                ret = mid;
            }else l = mid + 1;
        }
        System.out.println(ret);
    }
}