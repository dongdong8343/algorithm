import java.io.*;
import java.util.*;
public class Baekjoon24416 {
    static int n, ret = 0, ret2 = 0;
    static int[] dp = new int[45];
    static void go1(int n){
        dp[1] = 1; dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            ret2++;
        }
    }
    static int go2(int n){
        if(n == 1 || n == 2){
            ret++;
            return 1;
        }else return(go2(n - 1) + go2(n - 2));
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        go1(n);
        go2(n);
        System.out.println(ret + " " + ret2);
    }
}