import java.util.*;
import java.io.*;
public class BaekjoonRe1509_2 {
    static String s;
    static int n;
    static char[] a = new char[2504];
    static int[] dp2 = new int[2504];
    static boolean[][] dp1 = new boolean[2504][2504];
    static int go(int here){
        if(here == n) return 0;
        if(dp2[here] != 987654321) return dp2[here];
        for(int i = 1; i + here <= n; i++){
            if(dp1[here][i]) {
                dp2[here] = Math.min(dp2[here], go(here + i) + 1);
            }
        }
        return dp2[here];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        n = s.length();
        for(int i = 0; i < n; i++) a[i] = s.charAt(i);
        for(int i = 0; i < n; i++) dp1[i][1] = true;
        for(int i = 0; i < n - 1; i++) {
            if(a[i] == a[i + 1]) dp1[i][2] = true;
        }
        for(int i = 3; i <= n; i++){
            for(int j = 0; j + i <= n; j++){
                if(a[j] == a[j + i - 1] && dp1[j + 1][i - 2]) dp1[j][i] = true;
            }
        }
        Arrays.fill(dp2, 987654321);
        System.out.println(go(0));
    }
}