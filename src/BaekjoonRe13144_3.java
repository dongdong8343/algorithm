import java.util.*;
import java.io.*;
public class BaekjoonRe13144_3 {
    static int n, e = 0, s = 0;
    static long ret = 0;
    static int[] arr = new int[100004];
    static int[] v = new int[100004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }
        while(true){
            if(v[arr[e]] != 0){
                ret += e - s;
                v[arr[s++]]--;
            }else {
                v[arr[e++]]++;
            }
            if(e == n) break;
        }
        ret += (long)(e - s)*(e - s + 1) / 2;
        System.out.println(ret);
    }
}