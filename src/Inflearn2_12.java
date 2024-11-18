import java.util.*;
import java.io.*;

public class Inflearn2_12 {
    static int n, m, ret = 0;
    static int[][] a = new int[14][24];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                int cnt = 0;
                for(int k = 0; k < m; k++){
                    int pi = 0, pj = 0;
                    for(int l = 0; l < n; l++){
                        if(a[k][l] == i) pi = l;
                        if(a[k][l] == j) pj = l;
                    }
                    if(pi < pj) cnt++;
                }
                if(cnt == m) ret++;
            }
        }

        System.out.println(ret);

        return;
    }
}