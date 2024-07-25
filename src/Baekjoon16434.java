import java.util.*;
import java.io.*;
public class Baekjoon16434 {
    static class Room{
        long at, h, num;
        Room(long num, long at, long h){
            this.num = num;
            this.at = at;
            this.h = h;
        }
    }
    static long n, atk, l, h, ret, sum = 0;
    static Room[] a = new Room[123460];
    static boolean check(long mid){
        long temp = mid, t = atk;
        for(int i = 0; i < n; i++){
            long h = a[i].h;
            long at = a[i].at;
            if(a[i].num == 1){
                long cnt1 = h / t;
                if(h % t != 0) cnt1++;
                long cnt2 = mid / at;
                if(mid % at != 0) cnt2++;
                if(cnt1 > cnt2) return false;
                mid -= at * (cnt1 - 1);
            }else{
                t += at;
                mid += h;
                if(mid > temp) mid = temp;
            }
        }
        return true;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        atk = Long.parseLong(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            a[i] = new Room(b, c, d);
            if(b == 1) sum += d * c;
        }
        l = 1; h = sum;
        while(l <= h){
            long mid = (l + h) / 2;
            if (check(mid)) {
                h = mid - 1;
                ret = mid;
            }else l = mid + 1;
        }
        System.out.println(ret);
    }
}
