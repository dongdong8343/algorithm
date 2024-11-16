import java.util.*;
import java.io.*;

public class Inflearn2_10 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ret = 0, n;
    static int[][] a = new int[54][54];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int t = a[i][j]; boolean is = true;
                for(int k = 0; k < 4; k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                    if(t <= a[ny][nx]){
                        is = false;
                        break;
                    }
                }
                if(is) ret++;
            }
        }

        System.out.println(ret);

        return ;
    }
}