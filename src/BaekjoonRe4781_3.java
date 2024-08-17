import java.util.*;
import java.io.*;
public class BaekjoonRe4781_3 {
    static int n, m;
    static int[] dp = new int[10004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            String[] temp = s.split("\\.");
            m = Integer.parseInt(temp[0]) * 100 + Integer.parseInt(temp[1]);
            if(n == 0 && m == 0) break;
            Arrays.fill(dp, 0);
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int cal = Integer.parseInt(st.nextToken());
                String t = st.nextToken();
                String[] temp1 = t.split("\\.");
                int price = Integer.parseInt(temp1[0]) * 100 + Integer.parseInt(temp1[1]);
                for(int j = price; j <= m; j++) dp[j] = Math.max(dp[j - price] + cal, dp[j]);
            }
            System.out.println(dp[m]);
        }
    }
}