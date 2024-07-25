import java.util.*;
import java.io.*;
public class BaekjoonRe2343_1 {
    static int n, m, l, h, ret, sum = 0, max = -987654321;
    static int[] a = new int[100004];
    static boolean check(int mid){
        if(max > mid) return false;
        int temp = mid, cnt = 1;
        for(int i = 0; i < n; i++){
            if(mid - a[i] < 0){
                cnt++;
                mid = temp;
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
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
            max = Math.max(a[i], max);
        }
        l = 0; h = sum;
        while(l <= h){
            int mid = (l + h) / 2;
            if(check(mid)){
                h = mid - 1;
                ret = mid;
            }else l = mid + 1;
        }
        System.out.println(ret);
    }
}