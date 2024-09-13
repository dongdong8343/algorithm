import java.io.*;
import java.util.*;
public class BaekjoonRe1514_2 {
    static int n;
    static String s1, s2;
    static int[] a = new int[104];
    static int[] b = new int[104];
    static int[][][][][] dp = new int[104][14][14][14][2];
    static int mod(int v){
        return v < 0 ? v + 10 : v % 10;
    }
    static int go(int idx, int x, int y, int z, int flag){
        if(idx == n) return 0;
        if(dp[idx][x][y][z][flag] != -1) return dp[idx][x][y][z][flag];
        if(mod(a[idx] + x) == mod(b[idx])){
            return dp[idx][x][y][z][flag] = Math.min(go(idx + 1, y, z, 0, 0), go(idx + 1, y, z, 0, 1));
        }
        dp[idx][x][y][z][flag] = 987654321;
        int t = flag == 1 ? 1 : -1;
        for(int i = 1; i <= 3; i++){
            dp[idx][x][y][z][flag] = Math.min(dp[idx][x][y][z][flag], go(idx, mod(x + i * t), y, z, flag) + 1);
            dp[idx][x][y][z][flag] = Math.min(dp[idx][x][y][z][flag], go(idx, mod(x + i * t), mod(y + i * t), z, flag) + 1);
            dp[idx][x][y][z][flag] = Math.min(dp[idx][x][y][z][flag], go(idx, mod(x + i * t), mod(y + i * t), mod(z + i * t), flag) + 1);
        }
        return dp[idx][x][y][z][flag];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s1 = br.readLine(); s2 = br.readLine();
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(String.valueOf(s1.charAt(i)));
            b[i] = Integer.parseInt(String.valueOf(s2.charAt(i)));
        }
        for(int[][][][] m1 : dp){
            for(int[][][] m2 : m1){
                for(int[][] m3 : m2){
                    for(int[] m4 : m3) Arrays.fill(m4, -1);
                }
            }
        }
        System.out.println(Math.min(go(0, 0, 0, 0, 0), go(0, 0, 0, 0, 1)));
    }
}