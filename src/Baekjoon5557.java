import java.util.*;
import java.io.*;
public class Baekjoon5557 {
    static int n;
    static int[] a = new int[104];
    static long[][] dp = new long[104][24];
    static long go(int num, int idx){
        if(num < 0 || num > 20) return 0;
        if(idx == n - 2) return num == a[n - 1] ? 1 : 0;
        if(dp[idx][num] != -1) return dp[idx][num];
        dp[idx][num] = 0;
        dp[idx][num] += go(num + a[idx + 1], idx + 1);
        dp[idx][num] += go(num - a[idx + 1], idx + 1);
        return dp[idx][num];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        for(long[] row : dp) Arrays.fill(row, -1);
        System.out.println(go(a[0], 0));
    }
}