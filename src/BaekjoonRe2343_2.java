import java.util.*;
import java.io.*;
public class BaekjoonRe2343_2 {
    static int n, m, ret = 0, l, h, max = -987654321;
    static int[] a = new int[100004];
    static boolean check(int mid){
        if(max > mid) return false;
        int cnt = 1;
        int temp = mid;
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
            int x = Integer.parseInt(st.nextToken());
            a[i] = x;
            max = Math.max(max, a[i]);
        }
        l = 0; h = 1000000001;
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