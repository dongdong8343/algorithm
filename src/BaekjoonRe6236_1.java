import java.util.*;
import java.io.*;
public class BaekjoonRe6236_1 {
    static int n, m, max = -987654321, ret = 0, l, h, sum = 0;
    static int[] a = new int[100004];
    static boolean check(int mid){
        int cnt = 1;
        int temp = mid;
        for(int i = 0; i < n; i++){
            if(a[i] > temp) return false;
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
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
            max = Math.max(a[i], max);
            sum += a[i];
        }
        l = max; h = sum;
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