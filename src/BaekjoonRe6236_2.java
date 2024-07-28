import java.util.*;
import java.io.*;
public class BaekjoonRe6236_2 {
    static long n, m, ret = 0, l, h, max = -987654321;
    static long[] a = new long[100004];
    static boolean check(long mid){
        long temp = mid;
        long cnt = 1;
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
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            a[i] = x;
            max = Math.max(x, max);
        }
        l = max; h = 1000000001;
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