import java.util.*;
import java.io.*;
public class BaekjoonRe14391 {
    static int n, m, ret = 0;
    static int[][] map = new int[8][8];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                char c = s.charAt(j);
                map[i][j] = Integer.parseInt(String.valueOf(c));
            }
        }
        for(int s = 0; s < (1 << (n * m)); s++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                int cur = 0;
                for(int j = 0; j < m; j++){
                    int idx = i * m + j;
                    if((s & (1 << idx)) != 0) cur = cur * 10 + map[i][j];
                    else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            for(int j = 0; j < m; j++){
                int cur = 0;
                for(int i = 0; i < n; i++){
                    int idx = i * m + j;
                    if((s & (1 << idx)) == 0) cur = cur * 10 + map[i][j];
                    else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            ret = Math.max(ret, sum);
        }
        System.out.println(ret);
    }
}