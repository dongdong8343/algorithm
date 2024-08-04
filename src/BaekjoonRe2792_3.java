import java.util.*;
import java.io.*;
public class BaekjoonRe2792_3 {
    static long n, m, l, h, ret = 0;
    static long[] a = new long[300004];
    static boolean check(long mid){
        long cnt = 0;
        for(int i = 0; i < m; i++){
            cnt += a[i] / mid;
            if(a[i] % mid != 0) cnt++;
        }
        return cnt <= n;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        l = 1; h = (int)1e9;
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