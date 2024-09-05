import java.util.*;
import java.io.*;
public class Baekjoon1514 {
    static int n;
    static int[] a = new int[104];
    static int[] b = new int[104];
    static int[][][][][] dp = new int[104][10][10][10][2];
    static int mod(int x){
        return x < 0 ? x + 10 : x % 10;
    }
    static int go(int idx, int x, int y, int z, int flag){
        if(idx == n) return 0;
        if(dp[idx][x][y][z][flag] != -1) return dp[idx][x][y][z][flag];
        // 비교한게 같다면 다음 인덱스로 넘어간다.
        if(mod(x + a[idx]) == mod(b[idx]))
            return dp[idx][x][y][z][flag] = Math.min(go(idx + 1, y, z, 0, 0), go(idx + 1, y, z, 0, 1));
        dp[idx][x][y][z][flag] = 987654321;
        int t = flag == 1 ? 1 : -1;
        for(int i = 1; i <= 3; i++){
            dp[idx][x][y][z][flag] = Math.min(dp[idx][x][y][z][flag], 1 + go(idx, mod(x + i * t), y, z, flag));
            dp[idx][x][y][z][flag] = Math.min(dp[idx][x][y][z][flag], 1 + go(idx, mod(x + i * t), mod(y + i * t), z, flag));
            dp[idx][x][y][z][flag] = Math.min(dp[idx][x][y][z][flag], 1 + go(idx, mod(x + i * t), mod(y + i * t), mod(z + i * t), flag));
        }
        return dp[idx][x][y][z][flag];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        s = br.readLine();
        for(int i = 0; i < n; i++) b[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        for(int[][][][] m1 : dp){
            for(int[][][] m2 : m1){
                for(int[][] m3 : m2){
                    for(int[] m4 : m3){
                        Arrays.fill(m4, -1);
                    }
                }
            }
        }
        System.out.println(Math.min(go(0, 0, 0, 0, 0), go(0, 0, 0, 0, 1)));
    }
}