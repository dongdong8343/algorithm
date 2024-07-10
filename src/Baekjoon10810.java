import java.util.*;
import java.io.*;
public class Baekjoon10810 {
    static int[] a = new int[104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for(int j = s; j <= e; j++){
                a[j] = x;
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.print(a[i] + " ");
        }
    }
}