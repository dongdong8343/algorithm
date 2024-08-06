import java.util.*;
import java.io.*;
public class Baekjoon2293 {
    static int n, k;
    static List<Integer> li = new ArrayList<>();
    static int[] dp = new int[10004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if(k >= x) li.add(x);
        }
        dp[0] = 1;
        for(int x : li){
            for(int i = x; i <= k; i++){
                dp[i] = dp[i] + dp[i - x];
            }
        }
        System.out.println(dp[k]);
    }
}