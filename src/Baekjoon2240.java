import java.util.*;
import java.io.*;
public class Baekjoon2240 {
    static int t, n;
    static int[] a= new int[1004];
    static int[][][] dp = new int[34][1004][2];
    static int go(int cnt, int time, int here){
        if(cnt == n){
            int temp = 0;
            for(int i = time; i <= t; i++){
                if(a[i] == here) temp++;
            }
            return temp;
        }
        if(time == t) return a[time] == here ? 1 : 0;
        if(dp[cnt][time][here] != 0) return dp[cnt][time][here];
        int x = 0;
        if(a[time] == here) x = 1;
        dp[cnt][time][here] = Math.max(go(cnt + 1, time + 1, here ^ 1) + x, go(cnt , time + 1, here) + x);
        return dp[cnt][time][here];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        a[0] = -1;
        for(int i = 1; i <= t; i++) a[i] = Integer.parseInt(br.readLine()) - 1;
        System.out.println(go(0, 0, 0));
    }
}