import java.util.*;
import java.io.*;
public class BaekjoonRe1280_3 {
    static long n, ret = 1;
    static long[] s = new long[2000004];
    static long[] c = new long[2000004];
    static long sum(long[] tree, int s, int e){
        if(s > e) return 0;
        return _sum(tree, e) - _sum(tree, s - 1);
    }
    static long _sum(long[] tree, int idx){
        long ret = 0;
        while(idx > 0){
            ret += tree[idx];
            idx -= (idx & -idx);
        }
        return ret;
    }
    static void update(long[] tree, int idx, long val){
        while(idx < 2000004){
            tree[idx] += val;
            idx += (idx & -idx);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            int x = Integer.parseInt(br.readLine()) + 1;
            if(i != 1){
                long left = (sum(c, 1, x - 1) * x - sum(s, 1, x - 1));
                long right = (sum(s, x + 1, 2000001) - sum(c, x + 1, 2000001) * x);
                ret = (ret * ((left + right) % 1000000007)) % 1000000007;
            }
            update(c, x, 1);
            update(s, x, x);
        }
        System.out.println(ret);
    }
}