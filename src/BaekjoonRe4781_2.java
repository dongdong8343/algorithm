import java.util.*;
import java.io.*;
import java.awt.Point;
public class BaekjoonRe4781_2 {
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
            if(n == 0 && m == 0) break;
            Point[] t = new Point[n + 4];
            int[] dp = new int[10004];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                s = st.nextToken();
                String[] temp = s.split("\\.");
                m1 = Integer.parseInt(temp[0]);
                m2 = Integer.parseInt(temp[1]);
                int y = m1 * 100 + m2;
                t[i] = new Point(x, y);
            }
            for(int i = 0; i < n; i++){
                for(int j = t[i].y; j <= m; j++){
                    dp[j] = Math.max(dp[j], dp[j - t[i].y] + t[i].x);
                }
            }
            System.out.println(dp[m]);
        }
    }
}