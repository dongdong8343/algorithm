import java.util.*;
import java.io.*;

public class Inflearn3_1 {
    static List<Integer> li = new ArrayList<>();
    static int[] a = new int[104];
    static int[] b = new int[104];
    static int p1 = 0, p2 = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());

        while(p1 < n && p2 < m){
            if(a[p1] < b[p2]){
                li.add(a[p1++]);
            }else{
                li.add(b[p2++]);
            }
        }

        while(p1 < n) li.add(a[p1++]);
        while(p2 < m) li.add(b[p2++]);

        for(int x : li) System.out.print(x + " ");

        return ;
    }
}
