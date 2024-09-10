import java.util.*;
import java.io.*;
public class BaekjoonRe1280_1 {
    static final int MAX = 200004;
    static final long mod = (long) 1e9 + 7;
    static int n;
    static long ret = 1;
    static long[] c = new long[MAX];
    static long[] s = new long[MAX];
    static long sum(long[] tree, int s, int e){
        if(s > e) return 0;
        return _sum(tree, e) - _sum(tree, s - 1);
    }
    static long _sum(long[] tree, int x){
        long _ret = 0;
        while(x > 0) {
            _ret += tree[x];
            x -= (x & -x);
        }
        return _ret;
    }
    static void update(long[] tree, int x, long v){
        while(x < MAX){
            tree[x] += v;
            x += (x & -x);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            int v = Integer.parseInt(br.readLine()) + 1;
            if(i != 1){
                long left = v * sum(c, 1, v - 1) - sum(s, 1, v - 1);
                long right = sum(s, v + 1, MAX - 1) - v * sum(c, v + 1, MAX - 1);
                ret = (ret * ((left + right) % mod)) % mod;
            }
            update(c, v, 1);
            update(s, v, v);
        }
        System.out.println(ret);
    }
}