import java.util.*;
import java.io.*;
public class BaekjoonRe1561_4 {
    static long n, m, l, h, cnt, ret;
    static long[] a = new long[10004];
    static boolean check(long mid){
        long cnt = m;
        for(int i = 0; i < m; i++){
            cnt += mid / a[i];
        }
        return cnt >= n;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) a[i] = Integer.parseInt(st.nextToken());
        if(n <= m) {
            System.out.println(n);
            System.exit(0);
        }
        l = 1; h = n * 30;
        while(l <= h){
            long mid = (l + h) / 2;
            if(check(mid)){
                h = mid - 1;
                ret = mid;
            }else l = mid + 1;
        }
        cnt = m;
        for(int i = 0; i < m; i++){
            cnt += (ret - 1) / a[i];
        }
        for(int i = 0; i < m; i++){
            if(ret % a[i] == 0) cnt++;
            if(cnt == n) {
                System.out.println(i + 1);
                System.exit(0);
            }
        }
    }
}