import java.util.*;
import java.io.*;
public class Baekjoon2798 {
    static int n, m, ret = 0;
    static int[] a = new int[104];
    static void go(int cnt, int sum, int idx){
        if(idx > n) return;
        if(cnt == 3){
            if(sum <= m) ret = Math.max(ret, sum);
            return;
        }
        go(cnt, sum, idx + 1);
        go(cnt + 1, sum + a[idx], idx + 1);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        go(0, 0, 0);
        System.out.println(ret);
    }
}