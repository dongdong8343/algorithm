import java.util.*;
import java.io.*;
public class BaekjoonRe2792_1 {
    static int n, m, max = -987654321, ret = 987654321, h, l;
    static int[] a = new int[300004];
    static boolean check(int mid){
        int cnt = 0;
        for(int i = 0; i < m; i++){
            cnt += a[i] / mid;
            if(a[i] % mid != 0) cnt++;
        }
        return cnt <= n;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++){
            a[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, a[i]);
        }
        l = 1; h = max;
        while(l <= h){
            int mid = (l + h) / 2;
            if(check(mid)){
                ret = Math.min(ret, mid);
                h = mid - 1;
            }else l = mid + 1;
        }
        System.out.println(ret);
    }
}