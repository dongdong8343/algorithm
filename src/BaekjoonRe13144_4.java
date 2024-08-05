import java.util.*;
import java.io.*;
public class BaekjoonRe13144_4 {
    static int n, e = 0, s = 0;
    static long ret = 0;
    static int[] a = new int[100004];
    static int[] v = new int[100004];
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        while(e < n){
            if(v[a[e]] == 0){
                v[a[e]]++;
                e++;
            }else{
                ret += e - s;
                v[a[s]]--;
                s++;
            }
        }
        ret += (long)(e - s) * (e - s + 1) / 2;
        System.out.println(ret);
    }
}