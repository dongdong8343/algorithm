import java.util.*;
import java.io.*;
public class BaekjoonRe17297_2 {
    static int[] dp = new int[44];
    static int n;
    static String s = "Messi Gimossi";
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0] = 0; dp[1] = 5; dp[2] = 13;
        for(int i = 3; i <= 39; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + 1;
        }
        n = Integer.parseInt(br.readLine()) - 1;
        for(int i = 39; i > 1; i--){
            if(n >= dp[i]) n -= dp[i] + 1;
        }
        if(n == -1 || n == 5) System.out.println("Messi Messi Gimossi");
        else System.out.println(s.charAt(n));
    }
}