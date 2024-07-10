import java.util.*;
import java.io.*;
public class Baekjoon10811 {
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
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int idx = e;
            int[] t = new int[104];
            for(int j = s; j <= e; j++){
                t[j] = a[idx--];
            }
            for(int j = s; j <= e; j++){
                a[j] = t[j];
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.print(a[i] + " ");
        }
    }
}