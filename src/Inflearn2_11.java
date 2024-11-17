import java.util.*;
import java.io.*;

public class Inflearn2_11 {
    static int n;
    static int[][] a = new int[1004][10];
    static boolean[][] t = new boolean[1004][1004];
    static int max = -1, ret;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(k == j) continue;
                    if(a[j][i] == a[k][i]) t[j][k] = true;
                }
            }
        }

        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(t[i][j]) cnt++;
            }
            if(max < cnt){
                max = cnt;
                ret = i + 1;
            }
        }

        System.out.println(ret);


        return ;
    }
}
