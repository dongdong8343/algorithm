import java.util.*;
import java.io.*;

public class Inflearn3_4 {
    static int n, m, cnt = 0, sum = 0, p1 = 0, p2 = 0;
    static int [] a =  new int[100004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        while(p1 < n || p2 < n){
            if(sum < m) sum += a[p1++];
            else sum -= a[p2++];
            if(sum == m) cnt++;
            if(p1 == n && sum < m) break;
        }

        System.out.println(cnt);

        return ;
    }
}
