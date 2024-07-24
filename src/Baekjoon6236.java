import java.util.*;
import java.io.*;
public class Baekjoon6236 {
    static int n, m, max = -987654321, ret = 1987654321, l = 0, h, sum = 0, cnt;
    static int[] a = new int[100004];
    static boolean check(int mid){
        int temp = mid;
        cnt = 1;
        for(int i = 0; i < n; i++){
            if(mid - a[i] < 0){
                mid = temp;
                cnt++;
            }
            mid -= a[i];
        }
        if(mid < 0) return false;
        return cnt <= m;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, a[i]);
        }
        h = 1000000004; l = max;
        while(l <= h){
            int mid = (l + h) / 2;
            if(check(mid)){
                h = mid - 1;
                ret = Math.min(ret, mid);
            }else l = mid + 1;
        }
        System.out.println(ret);
    }
}