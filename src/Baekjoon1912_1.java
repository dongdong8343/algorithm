import java.util.*;
import java.io.*;
public class Baekjoon1912_1 {
    static int n, ret = -987654321, sum = 0;
    static int[] a = new int[100004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            sum += a[i];
            ret = Math.max(sum, ret);
            if(sum < 0) sum = 0;
        }
        System.out.println(ret);
    }
}