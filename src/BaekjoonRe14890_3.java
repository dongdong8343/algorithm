import java.util.*;
import java.io.*;
public class BaekjoonRe14890_3 {
    static int ret = 0, l, n;
    static int[][] a, b;
    static void go(int[][] map){
        for(int i = 0; i < n; i++){
            int cnt = 1;
            boolean error = false;
            for(int j = 0; j < n - 1; j++){
                if(map[i][j] == map[i][j + 1]) cnt++;
                else if(map[i][j] == map[i][j + 1] + 1 && cnt >= 0) cnt = -l + 1;
                else if(map[i][j] == map[i][j + 1] - 1 && cnt >= l) cnt = 1;
                else {
                    error = true;
                    break;
                }
            }
            if(!error && cnt >= 0) {
                ret++;
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        a = new int[n + 4][n + 4];
        b = new int[n + 4][n + 4];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                b[j][i] = a[i][j];
            }
        }
        go(a);
        go(b);
        System.out.println(ret);
    }
}