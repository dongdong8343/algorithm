import java.util.*;
import java.io.*;
public class BaekjoonRe_14627_4 {
    static int s, c;
    static long l, h, sum = 0, ret;
    static int[] a = new int[1000004];
    static boolean check(long mid){
        long cnt = 0;
        for(int i = 0; i < s; i++){
            cnt += a[i] / mid;
        }
        return cnt >= c;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 0; i < s; i++){
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }
        l = 1; h = (long)1e9;
        while(l <= h){
            long mid = (l + h) / 2;
            if(check(mid)){
                ret = mid;
                l = mid + 1;
            }else h = mid - 1;
        }
        System.out.println(sum - ret * c);
    }
}