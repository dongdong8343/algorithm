import java.util.*;
import java.io.*;
public class BaekjoonRe1561_1 {
    static long n, m, l, h, ret, temp;
    static long[] a = new long[10004];
    static boolean check(long mid){
        temp = m;
        for(int i = 0; i < m; i++){
            temp += mid / a[i];
        }
        return temp >= n;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) a[i] = Integer.parseInt(st.nextToken());
        if(n <= m){
            System.out.println(n);
            return;
        }
        l = 1; h = n * 30;
        while(l <= h){
            long mid = (l + h) / 2;
            if(check(mid)){
                h = mid - 1;
                ret = mid;
            }else l = mid + 1;
        }
        temp = m;
        for(int i = 0; i < m; i++){
            temp += (ret - 1) / a[i];
        }
        for(int i = 0; i < m; i++){
            if(ret % a[i] == 0) temp++;
            if(temp == n) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
