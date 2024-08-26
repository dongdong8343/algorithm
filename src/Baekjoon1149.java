import java.util.*;
import java.io.*;
public class Baekjoon1149 {
    static int n;
    static int[][] a = new int[1004][10];
    static int[][] dp = new int[1004][10];
    static int go(int idx, int before){
        if(idx == n) return 0;
        if(before != 4 && dp[idx][before] != 987654321) return dp[idx][before];
        for(int i = 0; i < 3; i++){
            if(before == i) continue;
            dp[idx][before] = Math.min(dp[idx][before], go(idx + 1, i) + a[idx][i]);
        }
        return dp[idx][before];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int[] m1 : dp){
            Arrays.fill(m1, 987654321);
        }
        System.out.println(go(0, 4));
    }
}