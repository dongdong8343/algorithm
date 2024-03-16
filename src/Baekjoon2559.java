import java.util.*;
import java.io.*;
public class Baekjoon2559 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ret = -10000004;

        int[] sum = new int[10000004];
        for(int i = 1; i <= n; i++){
            int temp = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + temp;
        }
        for(int i = k; i <= n; i++){
            ret = Math.max(ret, sum[i] - sum[i - k]);
        }
        System.out.println(ret);
    }
}
