import java.util.*;
import java.io.*;
public class Baekjoon1344 {
    static final int n = 18;
    static boolean[] che = new boolean[24];
    static double a, b;
    static double[][][] dp = new double[20][20][20];
    static double go(int idx, int x, int y){
        if(idx == n) return !che[x] || !che[y] ? 1.0 : 0.0;
        if(dp[idx][x][y] > -0.5) return dp[idx][x][y];

        dp[idx][x][y] = 0;
        dp[idx][x][y] += go(idx + 1, x + 1, y) * a * (1 - b);
        dp[idx][x][y] += go(idx + 1, x + 1, y + 1) * a * b;
        dp[idx][x][y] += go(idx + 1, x, y + 1) * (1 - a) * b;
        dp[idx][x][y] += go(idx + 1, x, y) * (1 - a) * (1 - b);

        return dp[idx][x][y];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        a /= 100; b /= 100;

        che[0] = true; che[1] = true;
        for(int i = 2; i <= 20; i++){
            if(che[i]) continue;
            for(int j = i * 2; j <= 20; j += i){
                che[j] = true;
            }
        }

        for(double[][] m1 : dp){
            for(double [] m2 : m1){
                Arrays.fill(m2, -1);
            }
        }

        System.out.printf("%.6f", go(0, 0, 0));
    }
}