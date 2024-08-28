import java.util.*;
import java.io.*;
public class BaekjoonRe10942_3 {
    static int n;
    static int[] a = new int[2004];
    static boolean[][] dp = new boolean[2004][2004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) dp[i][i] = true;
        for(int i = 0; i < n - 1; i++) {
            if(a[i] == a[i + 1]) dp[i][i + 1] = true;
        }
        for(int i = 2; i < n; i++){
            for(int j = 0; j <= n - i - 1; j++){
                if(a[j] == a[j + i] && dp[j + 1][j + i - 1]) dp[j][j + i] = true;
            }
        }
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if(dp[x][y]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}