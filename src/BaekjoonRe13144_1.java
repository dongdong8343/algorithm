import java.util.*;
import java.io.*;
public class BaekjoonRe13144_1 {
    static int n, s = 0, e = 0;
    static long ret = 0;
    static int[] a = new int[100004];
    static int[] cnt = new int[100004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        while(true){
            if(cnt[a[e]] != 0){
                ret += e - s;
                cnt[a[s++]]--;
            }else{
                cnt[a[e++]]++;
            }
            if(e >= n) break;
        }
        ret += (long)(e - s) * (e - s + 1) / 2;
        System.out.println(ret);
    }
}