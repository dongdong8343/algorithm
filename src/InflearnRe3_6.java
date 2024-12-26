import java.util.*;
import java.io.*;

public class InflearnRe3_6 {
    static int n, k, cnt = 0, l = 1, r = 1, max = -987654321;
    static int[] a = new int[100004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        while(r <= n){
            if(a[r] == 0) {
                cnt++;
            }
            if(cnt > k){
                max = Math.max(max, r - l);
                while(a[l] != 0) l++;
                cnt--;
                l++;
            }
            r++;
        }

        System.out.println(max);

        return;
    }
}