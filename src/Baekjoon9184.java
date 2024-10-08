import java.util.*;
import java.io.*;
public class Baekjoon9184 {
    static int[][][] dp = new int[54][54][54];
    static int w(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if(dp[a][b][c] != 0) return dp[a][b][c];
        if(a > 20 | b > 20 || c > 20)
            dp[a][b][c] = w(20, 20, 20);
        else if(a < b && b < c)
            dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        else
            dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return dp[a][b][c];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1) break;
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }
    }
}