import java.util.*;
import java.io.*;
public class Baekjoon2042 {
    static long n, m, k;
    static long[] arr = new long[1000004];
    static long[] tree = new long[1000004];
    static void update(int idx, long val){
        while(idx < 1000004){
            tree[idx] += val;
            idx += (idx & -idx);
        }
    }
    static long sum(int idx){
        long ret = 0;
        while(idx > 0){
            ret += tree[idx];
            idx -= (idx & -idx);
        }
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
        for(int i = 1; i <= n; i++){
            long x = Long.parseLong(br.readLine());
            arr[i] = x;
            update(i, x);
        }
        for(int i = 0; i < m + k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1){
                update(b, -arr[b]);
                update(b, c);
                arr[b] = c;
            }
            else{
                long ret = sum((int) c) - sum(b - 1);
                sb.append(ret).append('\n');
            }
        }
        System.out.println(sb);
    }
}