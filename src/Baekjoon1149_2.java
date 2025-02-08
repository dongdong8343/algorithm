import java.io.*;
import java.util.*;

public class Baekjoon1149_2 {
    static int ret = 987654321, n;
    static int[][] a = new int[1004][10];
    static int[][] dp = new int[1004][10];

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] st = br.readLine().split(" ");
            Arrays.fill(dp[i], 987654321);
            for(int j = 0; j < 3; j++){
                a[i][j] = Integer.parseInt(st[j]);
            }
        }

        for(int i = 0; i < 3; i++){
            ret = Math.min(ret, go(0, i));
        }

        System.out.println(ret);
    }

    static int go(int depth, int before){
        if(depth == n) return 0;
        if(dp[depth][before] != 987654321) return dp[depth][before];

        for(int i = 0; i < 3; i++){
            if(before == i) continue;
            dp[depth][before] = Math.min(dp[depth][before], a[depth][i] + go(depth + 1, i));
        }

        return dp[depth][before];
    }
}