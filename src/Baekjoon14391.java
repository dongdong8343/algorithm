import java.util.*;
import java.io.*;
public class Baekjoon14391 {
    static int n, m, ret = 0;
    static int[][] a;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        for(int s = 0; s < (1 << (n * m)); s++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                int cur = 0;
                for(int j = 0; j < m; j++){
                    int k = i * m + j;
                    if((s & (1 << k)) == 0) cur = cur * 10 + a[i][j];
                    else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            for(int i = 0; i < m; i++){
                int cur = 0;
                for(int j = 0; j < n; j++){
                    int k = j * m + i;
                    if((s & (1 << k)) != 0) cur = cur * 10 + a[j][i];
                    else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            ret = Math.max(sum, ret);
        }
        System.out.println(ret);
    }
}