import java.util.*;
import java.io.*;
public class BaekjoonRe2559 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        long ret = -1000000000004L;
        for(int j = k; j <= n; j++){
            if(j == k) ret = Math.max(ret, arr[j]);
            else {
                ret = Math.max(ret, (arr[j] - arr[j - k]));
            }
        }
        System.out.println(ret);
    }
}
