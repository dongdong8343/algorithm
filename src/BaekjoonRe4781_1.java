import java.util.*;
import java.io.*;
public class BaekjoonRe4781_1 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int[] dp = new int[10004];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            String[] temp = s.split("\\.");
            int m1 = Integer.parseInt(temp[0]);
            int m2 = Integer.parseInt(temp[1]);
            int m = m1 * 100 + m2;
            if(n == 0 && m == 0) break;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                s = st.nextToken();
                String[] arr = s.split("\\.");
                m1 = Integer.parseInt(arr[0]);
                m2 = Integer.parseInt(arr[1]);
                int p = m1 * 100 + m2;
                for(int j = p; j <= m; j++){
                    dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
            }
            System.out.println(dp[m]);
        }
    }
}