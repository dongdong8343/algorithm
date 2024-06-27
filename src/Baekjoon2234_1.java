import java.util.*;
import java.io.*;
public class Baekjoon2234_1 {
    static int m, n, cnt = 0, mx = 0, big = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] visited = new int[51][51];
    static int[][] a = new int[51][51];
    static int[] compSize = new int[2504];
    static int dfs(int y, int x, int cnt){
        if(visited[y][x] != 0) return 0;
        visited[y][x] = cnt;
        int ret = 1;
        for(int i = 0; i < 4; i++){
            if((a[y][x] & (1 << i)) == 0){
                int ny = y + dy[i];
                int nx = x + dx[i];
                ret += dfs(ny, nx, cnt);
            }
        }
        return ret;
    }
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
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == 0){
                    cnt++;
                    compSize[cnt] = dfs(i, j, cnt);
                    mx = Math.max(mx, compSize[cnt]);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i + 1 < m){
                    int a = visited[i + 1][j];
                    int b = visited[i][j];
                    if(a != b) big = Math.max(big, compSize[a] + compSize[b]);
                }
                if(j + 1 < n){
                    int a = visited[i][j + 1];
                    int b = visited[i][j];
                    if(a != b) big = Math.max(big, compSize[a] + compSize[b]);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(mx);
        System.out.println(big);
    }
}