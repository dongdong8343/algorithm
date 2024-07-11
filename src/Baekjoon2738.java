import java.util.*;
import java.io.*;
public class Baekjoon2738 {
    static int n, m;
    static int[][] a = new int[104][104];
    static int[][] b = new int[104][104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(a[i][j] + b[i][j] + " ");
            }
            System.out.println();
        }
    }
}