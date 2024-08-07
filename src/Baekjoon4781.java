import java.util.*;
import java.io.*;
public class Baekjoon4781 {
    static int ret = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            String[] arr = s.split("\\.");
            int m1 = Integer.parseInt(arr[0]);
            int m2 = Integer.parseInt(arr[1]);
            int m = m1 * 100 + m2;
            if(n == 0 && m2 == 0) break;
            int[] dp = new int[10004];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                s = st.nextToken();
                String[] t = s.split("\\.");
                m1 = Integer.parseInt(t[0]);
                m2 = Integer.parseInt(t[1]);
                int temp = m1 * 100 + m2;
                for(int j = temp; j <= m; j++){
                    dp[j] = Math.max(dp[j], dp[j - temp] + c);
                }
            }
            System.out.println(dp[m]);
        }
    }
}