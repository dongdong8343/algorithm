import java.util.*;
import java.io.*;

public class Inflearn3_3 {
    static int n, k, temp, max, p1, p2;
    static int[] a = new int[100004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < k; i++) max += a[i];

        temp = max; p2 = 0; p1 = k;
        while(p1 < n){
            temp += a[p1++];
            temp -= a[p2++];
            max = Math.max(temp, max);
        }

        System.out.println(max);

        return ;
    }
}