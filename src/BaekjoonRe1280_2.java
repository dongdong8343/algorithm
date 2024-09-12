import java.util.*;
import java.io.*;
public class BaekjoonRe1280_2 {
    static int n, x;
    static long ret = 1;
    static long[] c = new long[200004];
    static long[] s = new long[200004];
    static long sum(long[] a, int s, int e){
        if(s > e) return 0;
        return _sum(a, e) - _sum(a, s - 1);
    }
    static long _sum(long[] a, int e){
        long _ret = 0;
        while(e > 0){
            _ret += a[e];
            e -= (e & -e);
        }
        return _ret;
    }
    static void update(long[] a, int idx, int v){
        while(idx < 200004){
            a[idx] += v;
            idx += (idx & -idx);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            x = Integer.parseInt(br.readLine()) + 1;
            if(i != 0){
                long left = x * sum(c, 1, x - 1) - sum(s, 1, x - 1);
                long right = sum(s, x + 1, 200002) - x * sum(c, x + 1, 200002);
                ret = (ret * ((left + right) % 1000000007)) % 1000000007;
            }
            update(s, x, x);
            update(c, x, 1);
        }
        System.out.println(ret);
    }
}