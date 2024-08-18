import java.util.*;
import java.io.*;
public class BaekjoonRe10942_2 {
    static int n, m;
    static int[] a = new int[2004];
    static boolean[][] dp = new boolean[2004][2004];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) dp[i][i] = true;
        for(int i = 0; i < n; i++){
            if(a[i] == a[i + 1]) dp[i][i + 1] = true;
        }
        for(int j = 2; j < n; j++){
            for(int i = 0; i + j < n; i++){
                if(a[i] == a[i + j] && dp[i + 1][i + j - 1]) {
                    dp[i][i + j] = true;
                }
            }
        }
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if(dp[a][b]) sb.append("1").append("\n");
            else sb.append("0").append("\n");
        }
        System.out.println(sb);
    }
}