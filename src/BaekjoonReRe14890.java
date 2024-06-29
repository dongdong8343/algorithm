import java.util.*;
import java.io.*;
public class BaekjoonReRe14890 {
    static int n, l, ret = 0;
    static int [][] a, b;
    static void go(int[][] t){
        for(int i = 0; i < n; i++){
            int cnt = 1;
            int j = 0;
            for(j = 0; j < n - 1; j++){
                if(t[i][j] == t[i][j + 1]) cnt++;
                else if(t[i][j] + 1 == t[i][j + 1] && cnt >= l) cnt = 1;
                else if(t[i][j] - 1 == t[i][j + 1] && cnt >= 0) cnt = -l + 1;
                else break;
            }
            if(cnt >= 0 && j == n - 1)
                ret++;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        a = new int[n + 1][n + 1];
        b = new int[n + 1][n + 1];

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