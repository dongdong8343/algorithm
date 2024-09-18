import java.util.*;
import java.io.*;
public class BaekjoonRe1344_4 {
    static double a, b;
    static boolean[] che = new boolean[22];
    static double[][][] dp = new double[22][22][22];
    static double go(int idx, int aa, int bb){
        if(idx == 18) return (!che[aa] || !che[bb]) ? 1 : 0;
        if(dp[idx][aa][bb] > -0.5) return dp[idx][aa][bb];
        dp[idx][aa][bb] = 0;
        dp[idx][aa][bb] += go(idx + 1, aa + 1, bb + 1) * a * b;
        dp[idx][aa][bb] += go(idx + 1, aa + 1, bb) * a * (1 - b);
        dp[idx][aa][bb] += go(idx + 1, aa, bb + 1) * (1 - a) * b;
        dp[idx][aa][bb] += go(idx + 1, aa, bb) * (1 - a) * (1 - b);
        return dp[idx][aa][bb];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Double.parseDouble(br.readLine()) / 100;
        b = Double.parseDouble(br.readLine()) / 100;
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
        System.out.printf("%.6f", go(0, 0, 0));
    }
}