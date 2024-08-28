import java.util.*;
import java.io.*;
public class BaekjoonRe1344_3 {
    static boolean[] che = new boolean[24];
    static double x, y;
    static double[][][] dp = new double[24][24][24];
    static double go(int a, int b, int idx){
        if(idx == 18){
            if(!che[a] || !che[b]) return 1;
            else return 0;
        }
        if(dp[idx][a][b] > -0.5) return dp[idx][a][b];
        dp[idx][a][b] = 0;
        dp[idx][a][b] += go(a + 1, b + 1, idx + 1) * x * y;
        dp[idx][a][b] += go(a + 1, b, idx + 1) * x * (1 - y);
        dp[idx][a][b] += go(a, b + 1, idx + 1) * (1 - x) * y;
        dp[idx][a][b] += go(a, b, idx + 1) * (1 - x) * (1 - y);
        return dp[idx][a][b];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        che[0] = true; che[1] = true;
        for(int i = 2; i <= 18; i++){
            if(che[i]) continue;
            for(int j = i * 2; j <= 18; j += i){
                che[j] = true;
            }
        }
        for(double[][] m1 : dp){
            for(double[] m2 : m1){
                Arrays.fill(m2, -1);
            }
        }
        x = Double.parseDouble(br.readLine()) / 100;
        y = Double.parseDouble(br.readLine()) / 100;
        System.out.printf("%.6f", go(0, 0, 0));
    }
}