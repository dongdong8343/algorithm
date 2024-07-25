import java.util.*;
import java.io.*;
public class Baekjoon14627 {
    static long r, c, sum = 0, ret = 0, l, h;
    static List<Long> li = new ArrayList<>();
    static long check(long mid){
        long cnt = 0;
        for(long x : li){
            cnt += x / mid;
            if(cnt > c) return cnt - c;
        }
        return cnt - c;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        for(int i = 0; i < r; i++){
            long x = Long.parseLong(br.readLine());
            sum += x;
            li.add(x);
        }
        l = 1; h = 1000000001;
        while(l <= h){
            long mid = (l + h) / 2;
            long x = check(mid);
            if(x >= 0){
                ret = Math.max(ret, mid);
                l = mid + 1;
            }else h = mid - 1;
        }
        ret = sum - ret * c;
        System.out.println(ret);
    }
}