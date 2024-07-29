import java.util.*;
import java.io.*;
public class BaekjoonRe14627_3 {
    static long n, m, sum = 0, ret = 0, cnt, l, h;
    static long[] a = new long[1000004];
    static boolean check(long mid){
        cnt = 0;
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
            int x = Integer.parseInt(br.readLine());
            a[i] = x;
            sum += x;
        }
        l = 1; h = (long)1e9;
        while(l <= h){
            long mid = (l + h) / 2;
            if(check(mid)){
                l = mid + 1;
                ret = mid;
            }else h = mid - 1;
        }
        System.out.println(sum - (ret * m));
    }
}