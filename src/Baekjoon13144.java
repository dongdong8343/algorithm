import java.util.*;
import java.io.*;
public class Baekjoon13144 {
    static int n, e = 0, s = 0;
    static int[] a, cnt;
    static long ret = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n + 4];
        cnt = new int[n + 4];
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        while(e < n){
            if(cnt[a[e]] == 0) {
                cnt[a[e]]++;
                e++;
            }
            else{
                ret += e - s;
                cnt[a[s]]--;
                s++;
            }
        }
        ret += (long)(e - s) * (e - s + 1) / 2;
        System.out.println(ret);
    }
}