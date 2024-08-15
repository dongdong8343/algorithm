import java.util.*;
import java.io.*;
public class BaekjoonRe10942_1 {
    static int n, m, s, e;
    static int[] a = new int[2004];
    static boolean[][] dp = new boolean[2004][2004];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) dp[i][i] = true;
        for(int i = 0; i < n; i++) {
            if(a[i] == a[i + 1]) dp[i][i + 1] = true;
        }
        for(int size = 2; size < n; size++){
            for(int i = 0; i + size < n; i++){
                if(a[i] == a[i + size] && dp[i + 1][i + size - 1])
                    dp[i][i + size] = true;
            }
        }
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;
            if(dp[s][e]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}