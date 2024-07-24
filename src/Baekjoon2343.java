import java.util.*;
import java.io.*;
public class Baekjoon2343 {
    static int n, m, sum = 0, l = 0, h = sum, max = -987654321, ret;
    static int[] a = new int[100004];
    static boolean check(int mid){
        if(max > mid) return false;
        int cnt = 0;
        int temp = mid;
        for(int i = 0; i < n; i++){
            if(mid - a[i] < 0){
                cnt++;
                mid = temp;
            }
            mid -= a[i];
        }
        if(mid != temp) cnt++;
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
            max = Math.max(max, a[i]);
        }
        h = sum;
        while(l <= h){
            int mid = (l + h) / 2;
            if(check(mid)){
                ret = mid;
                h = mid - 1;
            }else l = mid + 1;
        }
        System.out.println(ret);
    }
}