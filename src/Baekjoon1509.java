import java.util.*;
import java.io.*;
public class Baekjoon1509 {
    static char[] a = new char[2504];
    static boolean[][] dp = new boolean[2504][2504];
    static int max, cnt = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        for(int i = 0; i < n; i++) a[i] = s.charAt(i);
        for(int i = 0; i < n; i++) dp[i][i] = true;
        for(int i = 0; i < n; i++) {
            if(a[i] == a[i + 1]) dp[i][i + 1] = true;
        }
        for(int size = 2; size < n; size++){
            for(int i = 0; i + size < n; i++){
                if(a[i] == a[i + size] && dp[i + 1][i + size - 1]) dp[i][i + size] = true;
            }
        }
        for(int i = 0; i < n; i = max + 1){
            cnt++;
            for(int j = i; j < n; j++){
                if(dp[i][j]) {
                    max = j;
                }
            }
        }
        System.out.println(cnt);
    }
}