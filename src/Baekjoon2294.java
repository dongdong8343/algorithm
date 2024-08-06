import java.util.*;
import java.io.*;
public class Baekjoon2294 {
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
            if(!li.contains(x) && x <= k) li.add(x);
        }
        if(li.size() == 0){
            System.out.println(-1);
            return;
        }
        Collections.sort(li);
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = li.get(0); i <= k; i++){
            for(int x : li){
                if(i % x == 0) dp[i] = Math.min(dp[i], i / x);
                if(i - x > 0 && dp[i - x] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - x] + 1);
            }
        }
        if(dp[k] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}