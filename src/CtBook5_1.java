import java.io.*;
import java.util.*;
public class CtBook5_1 {
    static int[][] a = new int[1004][1004];
    static int[][] v = new int[1004][1004];
    static int n, m;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static void dfs(int y, int x){
        v[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || v[ny][nx] == 1 || a[ny][nx] == 1) continue;
            dfs(ny, nx);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ret = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(v[i][j] == 0 && a[i][j] == 0){
                    dfs(i, j);
                    ret++;
                }
            }
        }

        System.out.println(ret);
    }
}