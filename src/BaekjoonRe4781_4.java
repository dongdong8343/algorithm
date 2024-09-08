import java.util.*;
import java.io.*;
public class BaekjoonRe4781_4 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            String[] arr = s.split("\\.");
            int m = Integer.parseInt(arr[0]) * 100 + Integer.parseInt(arr[1]);
            if(n == 0 && m == 0) break;
            int[] dp = new int[10004];
            for(int start = 0; start < n; start++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                s = st.nextToken();
                arr = s.split("\\.");
                int p = Integer.parseInt(arr[0]) * 100 + Integer.parseInt(arr[1]);
                for(int i = p; i <= m; i++) dp[i] = Math.max(dp[i], dp[i - p] + c);
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }
}