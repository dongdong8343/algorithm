import java.util.*;
import java.io.*;
public class Baekjoon1072 {
    static long x, y, per, l, h, ret = -1;
    static boolean check(long mid){
        long nx = x + mid;
        long ny = y + mid;
        long nper = ny * 100 / nx;
        return per != nper;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        per = y * 100 / x;
        l = 1; h = 1000000001;
        while(l <= h){
            long mid = (l + h) / 2;
            if(check(mid)){
                ret = mid;
                h = mid - 1;
            }else l = mid + 1;
        }
        System.out.println(ret);
    }
}