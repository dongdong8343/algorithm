import java.io.*;
import java.util.*;
public class BaekjoonRe14627_1 {
    static long n, m, l, h, ret, sum;
    static long[] a = new long[1000004];
    static boolean check(long mid){
        long cnt = 0;
        for(int i = 0; i < n; i++){
            cnt += a[i] / mid;
        }
        return cnt >= m;
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
        l = 1; h = 1000000001;
        while(l <= h){
            long mid = (l + h) / 2;
            if(check(mid)){
                l = mid + 1;
                ret = mid;
            }else h = mid - 1;
        }
        System.out.println(sum - ret * m);
    }
}