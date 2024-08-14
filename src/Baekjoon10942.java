import java.util.*;
import java.io.*;
public class Baekjoon10942 {
    static int n, m;
    static int[] a = new int[2004];
    static int[][] dp = new int[2004][2004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) dp[i][i] = 1;
        for(int i = 0; i < n; i++){
            if(a[i] == a[i + 1]) dp[i][i + 1] = 1;
        }
        for(int i = 2; i < n; i++){
            for(int j = 0; j <= n - i; j++){
                if(a[j] == a[j + i] && dp[j + 1][j + i - 1] == 1) dp[j][j + i] = 1;
            }
        }
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            if(dp[s][e] == 1) bw.write(1 + "\n");
            else bw.write(0 + "\n");
        }
        bw.flush();
        bw.close();
    }
}