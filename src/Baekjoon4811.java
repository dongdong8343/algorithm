import java.util.*;
import java.io.*;
public class Baekjoon4811 {
    static int n;
    static long[][] dp = new long[34][34];
    static long go(int w, int h){
        if(w == n && h == n) return 1;
        if(w > n || h > w) return 0;
        if(dp[w][h] != 0) return dp[w][h];
        dp[w][h] = go(w + 1, h) + go(w, h + 1);
        return dp[w][h];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            dp = new long[34][34];
            bw.write(go(0, 0) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}