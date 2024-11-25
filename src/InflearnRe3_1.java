import java.util.*;
import java.io.*;

public class InflearnRe3_1 {
    static int n, m, p1 = 0, p2= 0;
    static int[] a = new int[104];
    static int[] b = new int[104];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());

        while(p1 < n && p2 < m){
            if(a[p1] < b[p2]) sb.append(a[p1++]).append(' ');
            else sb.append(b[p2++]).append(' ');
        }

        while(p1 < n) sb.append(a[p1++]).append(' ');
        while(p2 < m) sb.append(b[p2++]).append(' ');

        System.out.println(sb.toString());

        return ;
    }
}
