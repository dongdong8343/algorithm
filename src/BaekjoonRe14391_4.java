import java.util.*;
import java.io.*;
public class BaekjoonRe14391_4 {
    static int n, m, ret = 0;
    static int[][] a = new int[8][8];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        for(int s = 0; s < (1 << n * m); s++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                int cnt = 0;
                for(int j = 0; j < m; j++){
                    int x = i * m + j;
                    if((s & (1 << x)) != 0) cnt = cnt * 10 + a[i][j];
                    else{
                        sum += cnt;
                        cnt = 0;
                    }
                }
                sum += cnt;
            }
            for(int i = 0; i < m; i++){
                int cnt = 0;
                for(int j = 0; j < n; j++){
                    int x = j * m + i;
                    if((s & (1 << x)) == 0) cnt = cnt * 10 + a[j][i];
                    else{
                        sum += cnt;
                        cnt = 0;
                    }
                }
                sum += cnt;
            }
            ret = Math.max(ret, sum);
        }
        System.out.println(ret);
    }
}
