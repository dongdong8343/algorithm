import java.util.*;
import java.io.*;
public class BaekjoonReRe14391 {
    static int r, c, ret = 0;
    static int[][] map;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for(int i = 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for(int s = 0; s < (1 << (r * c)); s++){
            int sum = 0;
            int cur = 0;
            for(int i = 0; i < r; i++){
                cur = 0;
                for(int j = 0; j < c; j++){
                    int idx = i * c + j;
                    if((s & (1 << idx)) != 0) cur = cur * 10 + map[i][j];
                    else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            cur = 0;
            for(int j = 0; j < c; j++){
                cur = 0;
                for(int i = 0; i < r; i++){
                    int idx = i * c + j;
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