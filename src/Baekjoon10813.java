import java.util.*;
import java.io.*;
public class Baekjoon10813 {
    static int n, m;
    static int[] a = new int[104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            a[i] = i;
        }
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int temp = a[x];
            a[x] = a[y];
            a[y] = temp;
        }
        for(int i = 1; i <= n; i++) System.out.print(a[i] + " ");
    }
}