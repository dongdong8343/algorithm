import java.util.*;
import java.io.*;
public class BaekjoonRe10942_4 {
    static int n, m, s, e;
    static int[] a = new int[2004];
    static int[][] dp = new int[2004][2004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) dp[i][i] = 1;
        for(int i = 0; i < n - 1; i++){
            if(a[i] == a[i + 1]) dp[i][i + 1] = 1;
        }
        for(int i = 2; i < n; i++){
            for(int j = 0; j <= n - i; j++){
                if(dp[j + 1][j + i - 1] == 1 && a[j] == a[j + i]) dp[j][j + i] = 1;
            }
        }
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;
            sb.append(dp[s][e]).append('\n');
        }
        System.out.println(sb);
    }
}