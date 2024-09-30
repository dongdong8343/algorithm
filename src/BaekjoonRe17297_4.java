import java.util.*;
import java.io.*;
public class BaekjoonRe17297_4 {
    static int n;
    static int[] dp = new int[54];
    static String s = "Messi Gimossi";
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()) - 1;
        dp[0] = 0; dp[1] = 5; dp[2] = 13;
        for(int i = 3; i <= 39; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + 1;
        }
        for(int i = 39; i >= 2; i--){
            if(n >= dp[i]) n -= dp[i] + 1;
        }
        if(n == 5 || n == -1) System.out.println("Messi Messi Gimossi");
        else System.out.println(s.charAt(n));
    }
}